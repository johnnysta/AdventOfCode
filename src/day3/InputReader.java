package day3;

import util.FileReader;

import java.util.List;

public class InputReader implements DataProvider {


    List<String> rawInput = FileReader.readInputFile("resources/Day3/input.txt");
    char[][] inputTable = new char[rawInput.size()][rawInput.get(0).length()];

    @Override
    public char[][] provideData() {
        processInput();
        return inputTable;
    }

    private void processInput() {
        for (int i = 0; i < rawInput.size(); i++) {
            String currentRow = rawInput.get(i);
            for (int j = 0; j < currentRow.length(); j++) {
                inputTable[i][j] = currentRow.charAt(j);
            }
        }
    }


}
