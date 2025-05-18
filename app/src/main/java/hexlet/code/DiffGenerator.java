package hexlet.code;


import java.util.Map;
import java.util.HashMap;

import java.util.List;

import java.util.Set;
import java.util.TreeSet;

import java.util.stream.Collectors;

public class DiffGenerator {
    public static List<Map<String, Object>> generateDiff(Map<String, Object> data1, Map<String, Object> data2) {

        Set<String> keys = getKeys(data1, data2);

        var diff = keys.stream()
                .map(key -> {

                    if (!data1.containsKey(key)) {
                        return getDataValue(key, "added", data2.get(key));
                    } else if (!data2.containsKey(key)) {
                        return getDataValue(key, "removed", data1.get(key));
                    }

                    String valueOfData1 = String.valueOf(data1.get(key));
                    String valueOfData2 = String.valueOf(data2.get(key));

                    if (valueOfData1.equals(valueOfData2)) {
                        return getDataValue(key, "unchanged", data1.get(key));
                    }

                    return getDataValue(key, "changed", data1.get(key), data2.get(key));

                })
                .collect(Collectors.toList());
        return diff;
    }

    private static Map<String, Object> getDataValue(Object key, Object status, Object value) {
        Map<String, Object> dataValue = new HashMap<>();
        dataValue.put("key", key);
        dataValue.put("status", status);
        dataValue.put("value1", value);
        return dataValue;
    }

    private static Map<String, Object> getDataValue(Object key, Object status, Object value1, Object value2) {
        Map<String, Object> dataValue = getDataValue(key, status, value1);
        dataValue.put("value2", value2);
        return dataValue;
    }

    private static Set<String> getKeys(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        return keys;
    }

}
