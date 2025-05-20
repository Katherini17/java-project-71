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

    /////////////////////////////////////////////////
    private static Path hexletJsonFile1;
    private static Path hexletJsonFile2;

    private static Path hexletYamlFile1;
    private static Path hexletYamlFile2;


    private static Path getFixturePath(String filename) {
        return Paths.get("src", "test", "resources", "fixtures", filename)
                .toAbsolutePath()
                .normalize();
    }

    private static String readFixtures(String fileName) throws IOException {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    static void preparePaths() {
        jsonFilePath1 = getFixturePath("nested-file1.json");
        jsonFilePath2 = getFixturePath("nested-file2.json");

        yamlFilePath1 = getFixturePath("nested-file1.yml");
        yamlFilePath2 = getFixturePath("nested-file2.yml");

        /// //////////////////////////////////////////
        hexletJsonFile1 = getFixturePath("hexlet-fixtures/file1.json");
        hexletJsonFile2 = getFixturePath("hexlet-fixtures/file2.json");

        hexletYamlFile1 = getFixturePath("hexlet-fixtures/file1.yml");
        hexletYamlFile2 = getFixturePath("hexlet-fixtures/file2.yml");


    }

    @Test
    void testJsonDiffGenerationInStylish() throws Exception {
        String expectedDiff = readFixtures("nested-diff.txt");
        String actualDiff = Differ.generate(jsonFilePath1.toString(), jsonFilePath2.toString(), "stylish");

        assertEquals(expectedDiff, actualDiff);
    }

    @Test
    void testYamlDiffGenerationInStylish() throws Exception {
        String expectedDiff = readFixtures("nested-diff.txt");
        String actualDiff = Differ.generate(yamlFilePath1.toString(), yamlFilePath2.toString(), "stylish");

        assertEquals(expectedDiff, actualDiff);
    }

    @Test
    void testJsonDiffGenerationInPlain() throws Exception {
        String expectedDiff = readFixtures("plain-diff.txt");
        String actualDiff = Differ.generate(jsonFilePath1.toString(), jsonFilePath2.toString(), "plain");

        assertEquals(expectedDiff, actualDiff);
    }

    @Test
    void testYamlDiffGenerationInPlain() throws Exception {
        String expectedDiff = readFixtures("plain-diff.txt");
        String actualDiff = Differ.generate(yamlFilePath1.toString(), yamlFilePath2.toString(), "plain");

        assertEquals(expectedDiff, actualDiff);
    }

    @Test
    void testJsonDiffGenerationInJson() throws Exception {
        String expectedDiff = readFixtures("json-diff.txt");
        String actualDiff = Differ.generate(jsonFilePath1.toString(), jsonFilePath2.toString(), "json");

        assertEquals(expectedDiff, actualDiff);
    }

    @Test
    void testYamlDiffGenerationInJson() throws Exception {
        String expectedDiff = readFixtures("json-diff.txt");
        String actualDiff = Differ.generate(yamlFilePath1.toString(), yamlFilePath2.toString(), "json");

        assertEquals(expectedDiff, actualDiff);
    }

    /////////////////////////////////////////////////////////////////////
    @Test
    void hexletTestJsonInStylish() throws Exception {
        String expectedDiff = readFixtures("hexlet-fixtures/result_stylish.txt");
        String actualDiff = Differ.generate(hexletJsonFile1.toString(), hexletJsonFile2.toString(), "stylish");

        assertEquals(expectedDiff, actualDiff);
    }

    @Test
    void hexletTestYamlInStylish() throws Exception {
        String expectedDiff = readFixtures("hexlet-fixtures/result_stylish.txt");
        String actualDiff = Differ.generate(hexletYamlFile1.toString(), hexletYamlFile2.toString(), "stylish");

        assertEquals(expectedDiff, actualDiff);
    }

    @Test
    void hexletTestJsonInPlain() throws Exception {
        String expectedDiff = readFixtures("hexlet-fixtures/result_plain.txt");
        String actualDiff = Differ.generate(hexletJsonFile1.toString(), hexletJsonFile2.toString(), "plain");

        assertEquals(expectedDiff, actualDiff);
    }

    @Test
    void hexletTestYamlInPlain() throws Exception {
        String expectedDiff = readFixtures("hexlet-fixtures/result_plain.txt");
        String actualDiff = Differ.generate(hexletYamlFile1.toString(), hexletYamlFile2.toString(), "plain");

        assertEquals(expectedDiff, actualDiff);
    }
}
