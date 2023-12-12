package day2;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

    private static final int RED_CUBES = 12;
    private static final int BLUE_CUBES = 14;
    private static final int GREEN_CUBES = 13;

    private static final int RED = 0;
    private static final int BLUE = 1;
    private static final int GREEN = 2;

    int solution1 = 0;
    long solution2 = 0;

    private List<int[]> inputData = new ArrayList<>();

    public void run() {
        InputReader inputReader = new InputReader();
        //part 1
        inputData = inputReader.provideData();
        System.out.println(processInputData_Part1());

        //part 2
        System.out.println(processInputData_Part2());
    }

    private int processInputData_Part1() {
        for (int i = 0; i < inputData.size(); i++) {
            int[] lineData = inputData.get(i);
            if ((lineData[RED] <= RED_CUBES) &&
                    (lineData[BLUE] <= BLUE_CUBES) &&
                    (lineData[GREEN] <= GREEN_CUBES)) {
                solution1 += i + 1;
            }
        }
        return solution1;
    }


    private long processInputData_Part2() {
        inputData.forEach(lineData -> solution2 += (long) lineData[RED] * lineData[BLUE] * lineData[GREEN]);
        return solution2;
    }

}
