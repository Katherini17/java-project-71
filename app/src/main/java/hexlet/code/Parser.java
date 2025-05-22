package hexlet.code;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Parser {

    private static ObjectMapper objectMapper;

    public static Map<String, Object> getData(FileData fileData) throws Exception {
        String fileContent = fileData.getFileContent();
        String fileExtension = fileData.getFileExtension();
        setObjectMapper(fileExtension);

        return objectMapper.readValue(fileContent, new TypeReference<>() { });
    }

    private static void setObjectMapper(String fileExtension) throws Exception {
        switch (fileExtension) {
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


}
