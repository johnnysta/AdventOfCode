package day1;

import java.util.ArrayList;
import java.util.List;

import static util.FileReader.readInputFile;

public class InputReader implements DataProvider {


    List<String> inputData = new ArrayList<>();

    @Override
    public List<String> provideData() {
        return inputData;
    }


    public InputReader() {
        inputData = readInputFile("resources/Day1/input.txt");
    }
}
