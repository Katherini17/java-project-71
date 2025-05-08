package hexlet.code;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static hexlet.code.Parser.getData;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        Map<String, Object> data1 = getData(filePath1);
        Map<String, Object> data2 = getData(filePath2);

        String diff = generateDiffLine(data1, data2);

        return String.format("{%n%s%n}", diff);
    }

    private static Set<String> getKeys(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new HashSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        return keys;
    }

    private static String generateDiffLine(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = getKeys(data1, data2);

        String diff = keys.stream()
                .sorted()
                .map(key -> {
                    String keyPart = String.format(" %s: ", key);

                    String valueOfData1 = String.valueOf(data1.get(key));
                    String valueOfData2 = String.valueOf(data2.get(key));

                    if (!data1.containsKey(key)) {
                        return String.format("  +%s%s", keyPart, valueOfData2);
                    } else if (!data2.containsKey(key)) {
                        return String.format("  -%s%s", keyPart, valueOfData1);
                    }

                    if (valueOfData1.equals(valueOfData2)) {
                        return String.format("   %s%s", keyPart, valueOfData1);
                    }

                    return String.format("  -%s%s%n  +%s%s", keyPart, valueOfData1, keyPart, valueOfData2);
                })
                .collect(Collectors.joining("\n"));

        return diff;
    }
}
