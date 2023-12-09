package day1;

import java.util.ArrayList;
import java.util.List;

import static util.FileReader.readInputFile;

public class InputReader implements DataProvider {


    List<Integer> inputData = new ArrayList<>();

    @Override
    public List<Integer> provideData() {
        return inputData;
    }


    public InputReader() {
        List<String> inputLines = readInputFile("resources/Day1/input.txt");
        char firstNumChar = ' ';
        char lastNumChar = ' ';
        for (String inputLine : inputLines) {
            for (int i = 0; i < inputLine.length(); i++) {
                if (inputLine.charAt(i) >= '0' && inputLine.charAt(i) <= '9') {
                    firstNumChar = inputLine.charAt(i);
                    break;
                }
            }
            for (int i = inputLine.length() - 1; i >= 0; i--) {
                if (inputLine.charAt(i) >= '0' && inputLine.charAt(i) <= '9') {
                    lastNumChar = inputLine.charAt(i);
                    break;
                }
            }
            System.out.println("first: " + firstNumChar);
            System.out.println("last: " + lastNumChar);
            if (firstNumChar != ' ') {
                inputData.add(10 * (firstNumChar - '0') + (lastNumChar - '0'));
            }
        }
        System.out.println(inputData);
    }
}
