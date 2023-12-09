package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {


    public static List<String> readInputFile(String inputPathString) {
        List<String> inputLines = new ArrayList<>();
        Path inputPath = Path.of(inputPathString);
        try (BufferedReader reader = Files.newBufferedReader(inputPath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                inputLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputLines;
    }
}
