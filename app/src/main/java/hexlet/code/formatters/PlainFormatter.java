package hexlet.code.formatters;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PlainFormatter {

    public static String formatPlain(Map<String, Map<String, Object>> diff) {
        Set<String> keys = diff.keySet();
        return keys.stream()
                .map(key -> {
                    Map<String, Object> valueData = diff.get(key);
                    String formattedkey = String.format("'%s'", key);
                    String status = String.valueOf(valueData.get("status"));
                    String value1 = "changed".equals(status)
                            ? getFormattedValue(valueData.get("fromValue"))
                            : getFormattedValue(valueData.get("value"));

                    switch (status) {
                        case "added":
                            return String.format("Property %s was added with value: %s",
                                    formattedkey, value1);
                        case "removed":
                            return String.format("Property %s was removed", formattedkey);
                        case "changed":
                            String value2 = getFormattedValue(valueData.get("toValue"));
                            return String.format("Property %s was updated. From %s to %s",
                                    formattedkey, value1, value2);
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
