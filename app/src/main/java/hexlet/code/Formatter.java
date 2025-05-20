package hexlet.code;

import java.util.Map;

import static hexlet.code.formatters.JsonFormatter.formatJson;
import static hexlet.code.formatters.PlainFormatter.formatPlain;
import static hexlet.code.formatters.StylishFormatter.formatStylish;

class Formatter {

    static String format(Map<String, Map<String, Object>> diff, String formatName) throws Exception {
        switch (formatName) {
            case "stylish":
                return formatStylish(diff);
            case "plain":
                return formatPlain(diff);
            case "json":
                return formatJson(diff);
            default:
                throw new Exception("Incorrect format");
        }
    }
}

