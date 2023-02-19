package utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class StringParser {

    public static String HTMLToString(String filepath) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));
        return reader.lines().collect(Collectors.joining("\n"));
    }
}
