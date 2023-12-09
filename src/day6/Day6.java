package day6;

import java.util.List;

public class Day6 {

    List<Long> times;
    List<Long> distances;


    public void run() {
        //Part 1
        DataProvider inputReader1 = new InputReaderForPart1();
        times = inputReader1.provideTimes();
        distances = inputReader1.provideDistances();
        System.out.println("Win options for part 1: " + calculateWinOptions());


        //Part 2
        DataProvider inputReader2 = new InputReaderForPart2();
        times = inputReader2.provideTimes();
        distances = inputReader2.provideDistances();
        System.out.println("Win options for part 2: " + calculateWinOptions());
    }

    private int calculateWinOptions() {
        int[] winOptions = new int[times.size()];
        for (int i = 0; i < times.size(); i++) {
            long time = times.get(i);
            long bestDistance = distances.get(i);
            for (int chargeTime = 0; chargeTime <= time; chargeTime++) {
                long currentDistance = (chargeTime * (time - chargeTime));
                if (currentDistance > bestDistance) {
                    winOptions[i]++;
                }
            }
        }
        int totalWinOptions = winOptions[0];
        for (int i = 1; i < winOptions.length; i++) {
            totalWinOptions *= winOptions[i];
        }
        return totalWinOptions;
    }


}
