package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day4Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/input4_1.txt"));

        int count = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] word = line.split(",");
            int[] ints = Arrays.stream(word[0].split("-")).mapToInt(Integer::parseInt).toArray();
            int[] ints2 = Arrays.stream(word[1].split("-")).mapToInt(Integer::parseInt).toArray();
            if ((ints[0] <= ints2[0] && ints[1] >= ints2[1])
                    || (ints2[0] <= ints[0] && ints2[1] >= ints[1])) {
                count++;
            }
        }
        System.out.println(count);
    }
}