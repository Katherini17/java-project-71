package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    private static Path jsonFilePath1;
    private static Path jsonFilePath2;

    private static Path yamlFilePath1;
    private static Path yamlFilePath2;

    private static Path getFixturePath(String filename) {
        return Paths.get("src", "test", "resources", "fixtures", filename)
                .toAbsolutePath()
                .normalize();
    }

    private static String readFixtures(String filename) throws IOException {
        Path filePath = getFixturePath(filename);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    static void preparePaths() {
        jsonFilePath1 = getFixturePath("file1.json");
        jsonFilePath2 = getFixturePath("file2.json");

        yamlFilePath1 = getFixturePath("file1.yml");
        yamlFilePath2 = getFixturePath("file2.yml");

    }

    @Test
    void testJsonDiffGeneration() throws Exception {
        String expectedDiff = readFixtures("diff.txt");
        String actualDiff = Differ.generate(jsonFilePath1.toString(), jsonFilePath2.toString());

        assertEquals(expectedDiff, actualDiff);
    }

    @Test
    void testYamlDiffGeneration() throws Exception {
        String expectedDiff = readFixtures("diff.txt");
        String actualDiff = Differ.generate(yamlFilePath1.toString(), yamlFilePath2.toString());

        assertEquals(expectedDiff, actualDiff);
    }

}
