package day2;

import java.util.ArrayList;
import java.util.List;

import static util.FileReader.readInputFile;

public class InputReader implements DataProvider {

    private static final int RED = 0;
    private static final int BLUE = 1;
    private static final int GREEN = 2;

    private final List<int[]> inputData = new ArrayList<>();

    @Override
    public List<int[]> provideData() {
        return inputData;
    }


    public InputReader() {
        List<String> rawInputData = readInputFile("resources/Day2/input.txt");
        processInputData(rawInputData);
    }

    private void processInputData(List<String> rawInputData) {
        for (String rawInputRow : rawInputData) {
            String actualSubString = rawInputRow.trim().substring(rawInputRow.indexOf(':') + 1);
            String[] grabs = actualSubString.trim().split("; ");
            int[] maxValues = new int[3];
            for (String set : grabs) {
                String[] cubes = set.split(", ");
                for (String s : cubes) {
                    String[] cube = s.split(" ");
                    switch (cube[1]) {
                        case "red" -> {
                            maxValues[RED] = Math.max(maxValues[RED], Integer.parseInt(cube[0]));
                        }
                        case "blue" -> {
                            maxValues[BLUE] = Math.max(maxValues[BLUE], Integer.parseInt(cube[0]));
                        }
                        case "green" -> {
                            maxValues[GREEN] = Math.max(maxValues[GREEN], Integer.parseInt(cube[0]));
                        }
                    }
                }
            }
            inputData.add(maxValues);
        }
    }


}
