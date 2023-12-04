import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    //Day 4: Scratchcards

    private static int scratchCardsResult() {
        List<String> inputLines = readInputFile("resources/Day4/input.txt");

        List<List<Integer>> winnerNumbers = parseWinnerNumbers(inputLines);
        List<List<Integer>> actualNumbers = parseActualNumbers(inputLines);

        int result = 0;
        for (int i = 0; i < winnerNumbers.size(); i++) {
            List<Integer> winnerNumbersSublist = winnerNumbers.get(i);
            List<Integer> actualNumbersSublist = actualNumbers.get(i);
            result += calculatScore(winnerNumbersSublist, actualNumbersSublist);
        }
        return result;
    }

    private static int calculatScore(List<Integer> winnerNumbersSublist, List<Integer> actualNumbersSublist) {
        int score = 0;
        for (Integer actualNumber : actualNumbersSublist) {
            if (winnerNumbersSublist.contains(actualNumber)) {
                score = (score == 0) ? 1 : score * 2;
            }
        }
        return score;
    }

    private static List<List<Integer>> parseActualNumbers(List<String> inputLines) {
        List<List<Integer>> actualNumbersList = new ArrayList<>();
        for (String currentLine : inputLines) {
            String actualNumbersSubString = currentLine.substring(currentLine.indexOf(':') + 1, currentLine.indexOf('|'));
            String[] actualNumbersArray = actualNumbersSubString.trim().split("\s+");
            List<Integer> actualNumbersSubList = new ArrayList<>();
            for (String s : actualNumbersArray) {
                actualNumbersSubList.add(Integer.parseInt(s));
            }
            Collections.sort(actualNumbersSubList);
            actualNumbersList.add(actualNumbersSubList);
        }
        return actualNumbersList;
    }

    private static List<List<Integer>> parseWinnerNumbers(List<String> inputLines) {
        List<List<Integer>> winnerNumbersList = new ArrayList<>();
        for (String currentLine : inputLines) {
            String winnerNumbersSubString = currentLine.substring(currentLine.indexOf('|') + 1);
            String[] winnerNumbersArray = winnerNumbersSubString.trim().split("\s+");
            List<Integer> winnerNumbersSubList = new ArrayList<>();
            for (String s : winnerNumbersArray) {
                winnerNumbersSubList.add(Integer.parseInt(s));
            }
            Collections.sort(winnerNumbersSubList);
            winnerNumbersList.add(winnerNumbersSubList);
        }
        return winnerNumbersList;
    }


    static List<String> readInputFile(String inputPathString) {
        List<String> inputLines = new ArrayList<>();
        Path inputPath = Path.of(inputPathString);
        try (BufferedReader reader = Files.newBufferedReader(inputPath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                inputLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputLines;
    }


    public static void main(String[] args) {
        System.out.println(scratchCardsResult());
    }
}
