package hexlet.code;

import java.util.List;
import java.util.Map;

import static hexlet.code.DiffGenerator.generateDiff;
import static hexlet.code.Formatter.format;
import static hexlet.code.Parser.getData;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> data1 = getData(filePath1);
        Map<String, Object> data2 = getData(filePath2);
        List<Map<String, String>> diff = generateDiff(data1, data2);
        String formattedDiff = format(diff, format);

        return formattedDiff;
    }

}
