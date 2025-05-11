package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private static Path filePath1;
    private static Path filePath2;

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
    public static void preparePaths() throws Exception {
        filePath1 = getFixturePath("file1.json");
        filePath2 = getFixturePath("file2.json");
    }

    @Test
    public void testJsonDiffGeneration() throws Exception {
        String expectedDiff = readFixtures("jsonDiff.txt");
        String actualDiff = Differ.generate(filePath1.toString(), filePath2.toString());

        assertEquals(expectedDiff, actualDiff);
    }

}
