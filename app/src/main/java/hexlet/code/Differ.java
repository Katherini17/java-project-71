package hexlet.code;
import java.util.Map;

import static hexlet.code.DiffGenerator.generateDiff;
import static hexlet.code.FileReader.getFileData;
import static hexlet.code.Formatter.format;
import static hexlet.code.Parser.getData;

public class Differ {

    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {
        FileData fileData1 = getFileData(filePath1);
        FileData fileData2 = getFileData(filePath2);

        Map<String, Object> data1 = getData(fileData1);
        Map<String, Object> data2 = getData(fileData2);

        Map<String, Map<String, Object>> diff = generateDiff(data1, data2);

        return format(diff, formatName);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

}
