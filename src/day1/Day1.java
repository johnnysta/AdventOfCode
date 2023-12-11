package day1;


import java.util.ArrayList;
import java.util.List;

public class Day1 {


    List<String> inputData;

    List<Integer> processedInputData;

    String[] spelledNums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};


    public void run() {
        DataProvider inputReader = new InputReader();
        inputData = inputReader.provideData();
        System.out.println(processInputData_Part1(inputData).stream().mapToInt(Integer::intValue).sum());
        System.out.println(processInputData_Part2(inputData).stream().mapToInt(Integer::intValue).sum());
    }


    //Part 1
    List<Integer> processInputData_Part1(List<String> inputData) {
        List<Integer> processedData = new ArrayList<>();
        char firstNumChar = ' ';
        char lastNumChar = ' ';
        for (String inputLine : inputData) {
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
            if (firstNumChar != ' ') {
                processedData.add(10 * (firstNumChar - '0') + (lastNumChar - '0'));
            }
        }
        return processedData;
    }


    //Part 2
    List<Integer> processInputData_Part2(List<String> inputData) {
        ;
        List<Integer> processedData = new ArrayList<>();
        char firstNumChar = ' ';
        int firstNumCharPosition;
        char lastNumChar = ' ';
        int lastNumCharPosition;
        for (String inputLine : inputData) {
            firstNumCharPosition = -1;
            lastNumCharPosition = -1;
            for (int i = 0; i < inputLine.length(); i++) {
                if (inputLine.charAt(i) >= '0' && inputLine.charAt(i) <= '9') {
                    firstNumChar = inputLine.charAt(i);
                    firstNumCharPosition = i;
                    break;
                }
            }
            for (int i = inputLine.length() - 1; i >= 0; i--) {
                if (inputLine.charAt(i) >= '0' && inputLine.charAt(i) <= '9') {
                    lastNumChar = inputLine.charAt(i);
                    lastNumCharPosition = i;
                    break;
                }
            }
            int[] spelledNumsSearchResult = processSpelledNumsToNums(inputLine);

            if (spelledNumsSearchResult[1] != -1 &&
                    (((firstNumCharPosition > spelledNumsSearchResult[1]) ||
                            (firstNumCharPosition == -1)))) {
                firstNumChar = (char) ('0' + spelledNumsSearchResult[0]);
            }

            if (spelledNumsSearchResult[3] != -1 &&
                    (((lastNumCharPosition < spelledNumsSearchResult[3]) ||
                            (lastNumCharPosition == -1)))) {
                lastNumChar = (char) ('0' + spelledNumsSearchResult[2]);
            }

            if (firstNumChar != ' ') {
                processedData.add(10 * (firstNumChar - '0') + (lastNumChar - '0'));
            }
        }
        return processedData;
    }


    private int[] processSpelledNumsToNums(String inputLine) {

        int[] spelledNumsSearchResult = new int[4];
        int numStringLow = -1;
        int numStringPositionLow = -1;
        int numStringHigh = -1;
        int numStringPositionHigh = -1;

        boolean found = false;
        for (int k = 0; k < inputLine.length(); k++) {
            for (int i = 0; i < spelledNums.length; i++) {
                if (inputLine.length() - k >= spelledNums[i].length()) {
                    if (inputLine.substring(k, k + spelledNums[i].length()).equals(spelledNums[i])) {
                        numStringLow = i;
                        numStringPositionLow = k;
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                break;
            }
        }

        found = false;
        for (int k = inputLine.length() - 3; k >= 0; k--) {
            for (int i = 0; i < spelledNums.length; i++) {
                if (inputLine.length() - k >= spelledNums[i].length()) {
                    if (inputLine.substring(k, k + spelledNums[i].length()).equals(spelledNums[i])) {
                        numStringHigh = i;
                        numStringPositionHigh = k;
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                break;
            }
        }

        spelledNumsSearchResult[0] = numStringLow;
        spelledNumsSearchResult[1] = numStringPositionLow;
        spelledNumsSearchResult[2] = numStringHigh;
        spelledNumsSearchResult[3] = numStringPositionHigh;

        return spelledNumsSearchResult;
    }


}
