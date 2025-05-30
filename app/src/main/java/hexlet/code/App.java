package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public final class App implements Callable<Integer> {
    @Option(names = {"-f", "--format"}, description = "output format", defaultValue = "stylish")
    private String format;

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
        String diff = Differ.generate(filepath1, filepath2, format);
        System.out.println(diff);

        return 0;
    }

}
