package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Formatter {

    public static String format(List<Map<String, String>> diff, String format) throws Exception {
        switch (format) {
            case "stylish":
                return formatStylish(diff);

            default:
                throw new Exception("Incorrect format");
        }
    }

    private static String formatStylish(List<Map<String, String>> diff) {
        String diffLine = diff.stream()
                .map(dataValue -> {
                    String key = dataValue.get("key");
                    String status = dataValue.get("status");
                    String value1 = dataValue.get("value1");

                    String keyPart = String.format(" %s: ", key);

                    switch (status) {
                        case "added":
                            return String.format("  +%s%s", keyPart, value1);
                        case "removed":
                            return String.format("  -%s%s", keyPart, value1);
                        case "unchanged":
                            return String.format("   %s%s", keyPart, value1);
                        default:
                            String value2 = dataValue.get("value2");
                            return String.format("  -%s%s%n  +%s%s", keyPart, value1, keyPart, value2);
                    }
                })
                .collect(Collectors.joining("\n"));

        return String.format("{%n%s%n}", diffLine);
    }
}
