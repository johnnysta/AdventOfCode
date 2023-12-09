package day6;

import day6.DataProvider;
import util.FileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader implements DataProvider {


    List<Integer> times;
    List<Integer> distances;


    @Override
    public List<Integer> provideTimes() {
        return times;
    }

    @Override
    public List<Integer> provideDistances() {
        return distances;
    }


    public InputReader() {
        List<String> inputLines = FileReader.readInputFile("resources/Day6/input.txt");
        this.times = parseTimes(inputLines);
        this.distances = parseDistances(inputLines);
    }

    private List<Integer> parseTimes(List<String> inputLines) {
        String times = inputLines.get(0);
        return Arrays.stream(times
                        .substring(times.indexOf(':') + 1)
                        .trim()
                        .split(" +"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<Integer> parseDistances(List<String> inputLines) {
        String distances = inputLines.get(1);
        return Arrays.stream(distances
                        .substring(distances.indexOf(':') + 1)
                        .trim()
                        .split(" +"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
