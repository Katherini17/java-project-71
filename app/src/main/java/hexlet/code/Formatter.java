package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

import static hexlet.code.formatters.JsonFormatter.formatJson;
import static hexlet.code.formatters.PlainFormatter.formatPlain;
import static hexlet.code.formatters.StylishFormatter.formatStylish;

public class Formatter {

    public static String format(Map<String, Map<String, Object>> diff, String formatName)
            throws IllegalArgumentException, JsonProcessingException {
        switch (formatName) {
            case "stylish":
                return formatStylish(diff);
            case "plain":
                return formatPlain(diff);
            case "json":
                return formatJson(diff);
            default:
                throw new IllegalCallerException("Incorrect format");
        }
    }
}

