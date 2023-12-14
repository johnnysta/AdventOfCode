package day3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day3 {

    private char[][] inputTable;
    private char[][] extendedTable;
    private int sum;

    Set<Character> nonSymbols = new HashSet<>(Set.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'));

    private void findPartNumbers() {
        for (int i = 1; i < extendedTable.length - 1; i++) {
            findPartNumbersInLine(i);
        }
    }

    private void findPartNumbersInLine(int i) {
        for (int j = 1; j < extendedTable[i].length - 1; j++) {
            int numStartIndex = j;
            while (extendedTable[i][j] >= '0' && extendedTable[i][j] <= '9') {
                j++;
            }
            if (hasNeighborSymbols(i, numStartIndex, j - 1)) {
                sum += convertCharsToNum(i, numStartIndex, j - 1);
            }
        }
    }

    private int convertCharsToNum(int rowIndex, int numStartIndex, int endIndex) {
        int number = 0;
        for (int i = numStartIndex; i <= endIndex; i++) {
            number = number * 10 + (extendedTable[rowIndex][i] - '0');
        }
        return number;
    }

    private boolean hasNeighborSymbols(int rowIndex, int startIndex, int endIndex) {
        if (extendedTable[rowIndex][startIndex - 1] != '.') return true;
        if (extendedTable[rowIndex][endIndex + 1] != '.') return true;
        for (int j = startIndex - 1; j <= endIndex + 1; j++) {
            if (!nonSymbols.contains(extendedTable[rowIndex - 1][j])) {
                return true;
            }
        }
        for (int j = startIndex - 1; j <= endIndex + 1; j++) {
            if (!nonSymbols.contains(extendedTable[rowIndex + 1][j])) {
                return true;
            }
        }
        return false;
    }

    private void extendTable() {
        extendedTable = new char[inputTable.length + 2][inputTable[0].length + 2];
        Arrays.fill(extendedTable[0], '.');
        Arrays.fill(extendedTable[extendedTable.length - 1], '.');

        for (int i = 1; i < extendedTable.length - 1; i++) {
            extendedTable[i][0] = '.';
            extendedTable[i][extendedTable.length - 1] = '.';
        }

        for (int i = 0; i < inputTable.length; i++) {
            for (int j = 0; j < inputTable[0].length; j++) {
                extendedTable[i + 1][j + 1] = inputTable[i][j];
            }
        }

        printExtendedTable();
    }

    private void printExtendedTable() {
        for (int i = 0; i < extendedTable.length; i++) {
            for (int j = 0; j < extendedTable[0].length; j++) {
                System.out.print(extendedTable[i][j]);
            }
            System.out.println();
        }
    }

    public void run() {
        InputReader inputReader = new InputReader();
        this.inputTable = inputReader.provideData();
        extendTable();
        findPartNumbers();
        System.out.println(sum);
    }

}
