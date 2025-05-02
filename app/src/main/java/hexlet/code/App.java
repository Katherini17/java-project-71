package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;
// import hexlet.code.Differ;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    @Option(names = {"-f", "--format"}, description = "output format", defaultValue = "stylish")
    private String format = "stylish";

    @Parameters(index = "0", description = "path to the first file")
    private String filepath1;

    @Parameters(index = "1", description = "path to the second file")
    private String filepath2;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        // String diff = Differ.generate(filePath1, filePath2);
        System.out.println("Hello picocli");
        return 0;
    }
}
