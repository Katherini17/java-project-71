package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.w3c.dom.ls.LSOutput;

public class Parser {
    private static ObjectMapper objectMapper;
    public static Map<String, Object> getData(String filePath) throws Exception {
        String stringData = readFile(filePath);
        setObjectMapper(filePath);
        return objectMapper.readValue(stringData, new TypeReference<>() { });
    }

    private static void setObjectMapper(String filePath) throws Exception {
        String extension = getFileExtension(filePath);
        switch (extension) {
            case "json":
                objectMapper = new ObjectMapper();
                break;
            case "yml":
            case "yaml":
                objectMapper = new ObjectMapper(new YAMLFactory());
                break;
            default:
                throw new Exception("Incorrect file extension");
        }
    }

    private static Path getNormalizedPath(String filepath) {
        return Paths.get(filepath).toAbsolutePath().normalize();
    }

    private static String readFile(String filepath) throws IOException {
        Path normalizedPath = getNormalizedPath(filepath);
        return Files.readString(normalizedPath);
    }

    private static String getFileExtension(String filePath) {
        return List.of(filePath.split("\\."))
                .getLast();
    }
}
