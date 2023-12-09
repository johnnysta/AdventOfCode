package day1;


import java.util.List;

public class Day1 {

    List<Integer> inputData;

    public void run() {
        DataProvider inputReader = new InputReader();
        inputData = inputReader.provideData();
        System.out.println(inputData.stream().mapToInt(Integer::intValue).sum());
    }
}
