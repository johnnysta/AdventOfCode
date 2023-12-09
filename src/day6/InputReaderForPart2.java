package day6;

import util.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputReaderForPart2 implements DataProvider {


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


    public InputReaderForPart2() {
        List<String> inputLines = FileReader.readInputFile("resources/Day6/input.txt");
        this.times = parseTimes(inputLines);
        this.distances = parseDistances(inputLines);
    }

    private List<Long> parseTimes(List<String> inputLines) {
        String times = inputLines.get(0);
        ArrayList<Long> result = new ArrayList<>();
        result.add(Long.parseLong(times
                .substring(times.indexOf(':') + 1)
                .trim()
                .replaceAll(" +", "")));
        return result;
    }

    private List<Long> parseDistances(List<String> inputLines) {
        String times = inputLines.get(1);
        ArrayList<Long> result = new ArrayList<>();
        result.add(Long.parseLong(times
                .substring(times.indexOf(':') + 1)
                .trim()
                .replaceAll(" +", "")));
        return result;
    }
}
