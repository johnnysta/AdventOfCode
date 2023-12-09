package day6;

import util.FileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputReaderForPart1 implements DataProvider {


    List<Long> times;
    List<Long> distances;


    @Override
    public List<Long> provideTimes() {
        return times;
    }

    @Override
    public List<Long> provideDistances() {
        return distances;
    }


    public InputReaderForPart1() {
        List<String> inputLines = FileReader.readInputFile("resources/Day6/input.txt");
        this.times = parseTimes(inputLines);
        this.distances = parseDistances(inputLines);
    }

    private List<Long> parseTimes(List<String> inputLines) {
        String times = inputLines.get(0);
        return Arrays.stream(times
                        .substring(times.indexOf(':') + 1)
                        .trim()
                        .split(" +"))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    private List<Long> parseDistances(List<String> inputLines) {
        String distances = inputLines.get(1);
        return Arrays.stream(distances
                        .substring(distances.indexOf(':') + 1)
                        .trim()
                        .split(" +"))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }
}
