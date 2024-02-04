package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {
    public static String getForwardedVariables(String fileText) {
        var streamLines = Arrays.stream(fileText.split("\n"));
        var envLine = streamLines
            .filter(line -> !line.isEmpty())
            .filter(str -> str.startsWith("environment"))
            .map(line -> line.split("environment=")[1])
            .map(line -> line.replace("\"",""))
            .collect(Collectors.joining(","));
        var res = Arrays.stream(envLine.split(","))
            .filter(str -> str.startsWith("X_FORWARDED_"))
            .map(line -> line.replace("X_FORWARDED_", ""))
            .collect(Collectors.joining(","));
        return res;
    }
}
//END
