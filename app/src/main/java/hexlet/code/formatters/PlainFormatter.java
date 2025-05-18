package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlainFormatter {

    public static String formatPlain(List<Map<String, Object>> diff) {
        return diff.stream()
                .map(valueData -> {
                    String key = String.format("'%s'", String.valueOf(valueData.get("key")));
                    String status = String.valueOf(valueData.get("status"));
                    String value1 = getFormattedValue(valueData.get("value1"));

                    switch (status) {
                        case "added":
                            return String.format("Property %s was added with value1: %s", key, value1);
                        case "removed":
                            return String.format("Property %s was removed", key);
                        case "changed":
                            String value2 = getFormattedValue(valueData.get("value2"));
                            return String.format("Property %s was updated. From %s to %s", key, value1, value2);
                        default:
                            return "";
                    }
                })
                .filter(line -> !line.isEmpty())
                .collect(Collectors.joining("\n"));
    }

    private static String getFormattedValue(Object value) {
        String strValue = String.valueOf(value);

        if (value == null
                || value instanceof Number
                || value instanceof Boolean) {

            return strValue;
        } else if (value instanceof String) {

            return String.format("'%s'", strValue);
        }

        return "[complex value]";
    }

}
