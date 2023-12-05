package day4;

import java.util.*;

public class Day4 {

    //Day 4
    public void run() {

        DataProvider dataProvider = new InputReader();
        List<List<Integer>> winnerNumbers = dataProvider.provideWinnerNumbers();
        List<List<Integer>> actualNumbers = dataProvider.provideActualNumbers();


        System.out.println("Part1 solution: " + scratchCardsResultPart1(winnerNumbers, actualNumbers));
        System.out.println("Part2 solution: " + scratchCardsResultPart2(winnerNumbers, actualNumbers));
    }


    //Part 1
    private int scratchCardsResultPart1(List<List<Integer>> winnerNumbers, List<List<Integer>> actualNumbers) {
        int result = 0;
        for (int i = 0; i < winnerNumbers.size(); i++) {
            List<Integer> winnerNumbersSublist = winnerNumbers.get(i);
            List<Integer> actualNumbersSublist = actualNumbers.get(i);
            result += calculateDoubledScore(winnerNumbersSublist, actualNumbersSublist);
        }
        return result;
    }

    private int calculateDoubledScore(List<Integer> winnerNumbersSublist, List<Integer> actualNumbersSublist) {
        int score = 0;
        for (Integer actualNumber : actualNumbersSublist) {
            if (winnerNumbersSublist.contains(actualNumber)) {
                score = (score == 0) ? 1 : score * 2;
            }
        }
        return score;
    }


    //Part 2
    private int scratchCardsResultPart2(List<List<Integer>> winnerNumbers, List<List<Integer>> actualNumbers) {
        Map<Integer, Integer> cardsMap = new HashMap<>();
        int[] bonusCards = new int[10];
        for (int i = 0; i < winnerNumbers.size(); i++) {
            int normalScore = calculateNormalScore(winnerNumbers.get(i), actualNumbers.get(i));
            int currentCards = 1 + bonusCards[0];
            cardsMap.put(i, currentCards);
            shiftBonusCards(bonusCards);
            for (int j = 0; j < normalScore; j++) {
                bonusCards[j] += currentCards;
            }
        }
        return cardsMap.values().stream().mapToInt(Integer::intValue).sum();
    }

    private void shiftBonusCards(int[] bonusCards) {
        for (int i = 0; i < bonusCards.length - 1; i++) {
            bonusCards[i] = bonusCards[i + 1];
        }
        bonusCards[bonusCards.length - 1] = 0;
    }


    private int calculateNormalScore(List<Integer> winnerNumbersSublist, List<Integer> actualNumbersSublist) {
        int score = 0;
        for (Integer actualNumber : actualNumbersSublist) {
            if (winnerNumbersSublist.contains(actualNumber)) {
                score++;
            }
        }
        return score;
    }

}
