package hexlet.code;


import java.util.Map;
import java.util.HashMap;

import java.util.List;

import java.util.Set;
import java.util.TreeSet;

import java.util.stream.Collectors;

public class DiffGenerator {
    public static List<Map<String, String>> generateDiff(Map<String, Object> data1, Map<String, Object> data2) {

        Set<String> keys = getKeys(data1, data2);

        var diff = keys.stream()
                .map(key -> {
                    String valueOfData1 = String.valueOf(data1.get(key));
                    String valueOfData2 = String.valueOf(data2.get(key));

                    if (!data1.containsKey(key)) {
                        return getDataValue(key, "added", valueOfData2);
                    } else if (!data2.containsKey(key)) {
                        return getDataValue(key, "removed", valueOfData1);
                    }

                    if (valueOfData1.equals(valueOfData2)) {
                        return getDataValue(key, "unchanged", valueOfData1);
                    }

                    return getDataValue(key, "changed", valueOfData1, valueOfData2);
                })
                .collect(Collectors.toList());
        return diff;
    }

    private static Map<String, String> getDataValue(String key, String status, String value) {
        Map<String, String> dataValue = new HashMap<>();
        dataValue.put("key", key);
        dataValue.put("status", status);
        dataValue.put("value1", value);
        return dataValue;
    }

    private static Map<String, String> getDataValue(String key, String status, String value1, String value2) {
        Map<String, String> dataValue = getDataValue(key, status, value1);
        dataValue.put("value2", value2);
        return dataValue;
    }

    private static Set<String> getKeys(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        return keys;
    }

}
