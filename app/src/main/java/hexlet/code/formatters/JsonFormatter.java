package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Map;
import java.util.TreeMap;

public class JsonFormatter {
    public static String formatJson(Map<String, Map<String, Object>> diff) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        Map<String, Map<String, Object>> sortedDiff = new TreeMap<>(diff);
        return objectMapper.writeValueAsString(sortedDiff);
    }
}
