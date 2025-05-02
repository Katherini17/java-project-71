package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser {
    public static Map<String, Object> getData(String filePath) throws Exception {
        String stringData = readFile(filePath);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(stringData, new TypeReference<>() { });
    }

    private static Path getNormalizedPath(String filepath) {
        return Paths.get(filepath).toAbsolutePath().normalize();
    }

    private static String readFile(String filepath) throws IOException {
        Path normalizedPath = getNormalizedPath(filepath);
        return Files.readString(normalizedPath);
    }
}
