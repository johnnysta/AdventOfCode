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

    private List<int[]> inputData = new ArrayList<>();

    public void run() {
        InputReader inputReader = new InputReader();
        inputData = inputReader.provideData();
        checkInputData();
        System.out.println(solution1);
    }

    private void checkInputData() {
        for (int i = 0; i < inputData.size(); i++) {
            int[] lineData = inputData.get(i);
            if ((lineData[RED] <= RED_CUBES) &&
                    (lineData[BLUE] <= BLUE_CUBES) &&
                    (lineData[GREEN] <= GREEN_CUBES)) {
                solution1 = solution1 + (i + 1);
            }
        }
    }
}
