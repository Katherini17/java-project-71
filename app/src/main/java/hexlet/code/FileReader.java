package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    public static FileData getFileData(String filePath) throws IOException {
        String fileExtension = getFileExtension(filePath);
        String fileContent = readFile(filePath);

        return new FileData(fileContent, fileExtension);
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
