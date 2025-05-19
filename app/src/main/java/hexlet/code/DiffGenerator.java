package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DiffGenerator {
    public static Map<String, Map<String, Object>> generateDiff(Map<String, Object> data1, Map<String, Object> data2) {

        Set<String> keys = getKeys(data1, data2);

        return keys.stream()
                .collect(Collectors.toMap(key -> key, key -> {

                    if (!data1.containsKey(key)) {
                        return getDataValue("added", data2.get(key));
                    } else if (!data2.containsKey(key)) {
                        return getDataValue("removed", data1.get(key));
                    }

                    String valueOfData1 = String.valueOf(data1.get(key));
                    String valueOfData2 = String.valueOf(data2.get(key));

                    if (valueOfData1.equals(valueOfData2)) {
                        return getDataValue("unchanged", data1.get(key));
                    }

                    return getDataValue("changed", data1.get(key), data2.get(key));

                }));
    }

    private static Map<String, Object> getDataValue(Object status, Object value) {
        Map<String, Object> dataValue = new LinkedHashMap<>();
        dataValue.put("status", status);
        if ("changed".equals(status)) {
            dataValue.put("fromValue", value);
        } else {
            dataValue.put("value", value);
        }

        return dataValue;
    }

    private static Map<String, Object> getDataValue(Object status, Object value1, Object value2) {
        Map<String, Object> dataValue = getDataValue(status, value1);
        dataValue.put("toValue", value2);
        return dataValue;
    }

    private static Set<String> getKeys(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        return keys;
    }

}
