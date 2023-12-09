package day6;

import java.util.List;

public class Day6 {

    List<Integer> times;
    List<Integer> distances;


    public Day6() {
        DataProvider inputReader = new InputReader();
        times = inputReader.provideTimes();
        distances = inputReader.provideDistances();

        System.out.println(times);
        System.out.println(distances);
    }


    public int run() {
        int[] winOptions = new int[times.size()];
        for (int i = 0; i < times.size(); i++) {
            int time = times.get(i);
            int bestDistance = distances.get(i);
            for (int chargeTime = 0; chargeTime <= time; chargeTime++) {
                int currentDistance = (chargeTime * (time - chargeTime));
                if (currentDistance > bestDistance) {
                    winOptions[i]++;
                }
            }
        }
        int totalWinOptions = winOptions[0];
        System.out.println(winOptions[0]);
        for (int i = 1; i < winOptions.length; i++) {
            System.out.println(winOptions[i]);
            totalWinOptions *= winOptions[i];
        }
        return totalWinOptions;
    }


}
