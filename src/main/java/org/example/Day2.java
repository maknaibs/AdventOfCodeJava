package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/input.txt"));

        int score = 0;

        Map<Character, Integer> counts = new HashMap<>();
        counts.put('A', 1); //Rock
        counts.put('B', 2); //Paper
        counts.put('C', 3); //Scissors
        counts.put('X', 1); //loss
        counts.put('Y', 2); //draw
        counts.put('Z', 3); //win

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int opp = counts.get(line.charAt(0));
//            int me = counts.get(line.charAt(2));
            int outcome = counts.get(line.charAt(2));
            int me;

            if (outcome == 2) {
                me = opp;
            } else if (outcome == 3) {
                me = opp % 3 + 1;
            } else {
                me = opp == 1 ? 3 : opp - 1;
            }

            score = getScore(score, opp, me);
        }
        System.out.println("Score: " + score);
    }

    private static int getScore(int score, int opp, int me) {
        if (me == opp) {
            score += 3;
        }
        boolean isWin = (me - opp + 3) % 3 == 1;
        if (isWin) {
            score += 6;
        }

        score += me;
        return score;
    }
}

