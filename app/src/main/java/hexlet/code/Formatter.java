package hexlet.code;

import java.util.List;
import java.util.Map;

import static hexlet.code.formatters.PlainFormatter.formatPlain;
import static hexlet.code.formatters.StylishFormatter.formatStylish;

public class Formatter {

    public static String format(List<Map<String, Object>> diff, String formatName) throws Exception {
        switch (formatName) {
            case "stylish":
                return formatStylish(diff);
            case "plain":
                return formatPlain(diff);
            default:
                throw new Exception("Incorrect format");
        }
    }
}

