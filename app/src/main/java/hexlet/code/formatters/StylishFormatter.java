package hexlet.code.formatters;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StylishFormatter {
    public static String formatStylish(Map<String, Map<String, Object>> diff) {
        Set<String> keys = new TreeSet<>(diff.keySet());
        String diffLine = keys.stream()
                .map(key -> {
                    Map<String, Object> valueData = diff.get(key);
                    String status = valueData.get("status").toString();
                    String value1 = "changed".equals(status)
                            ? String.valueOf(valueData.get("fromValue"))
                            : String.valueOf(valueData.get("value"));


                    String keyPart = String.format(" %s: ", key);

                    switch (status) {
                        case "added":
                            return String.format("  +%s%s", keyPart, value1);
                        case "removed":
                            return String.format("  -%s%s", keyPart, value1);
                        case "unchanged":
                            return String.format("   %s%s", keyPart, value1);
                        default:
                            String value2 = String.valueOf(valueData.get("toValue"));
                            return String.format("  -%s%s%n  +%s%s", keyPart, value1, keyPart, value2);
                    }
                })
                .collect(Collectors.joining("\n"));

        return String.format("{%n%s%n}", diffLine);
    }
}
