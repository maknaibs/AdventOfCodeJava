package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/input.txt"));

        int max = 0;
        int current = 0;
        ArrayList<Integer> allValues = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.length() == 0) {
                max = Math.max(max, current);
                allValues.add(current);
                current = 0;
            } else {
                current += Integer.parseInt(line);
            }
        }
        max = Math.max(max, current);
        allValues.add(current);

        Collections.sort(allValues);
        int topThree = allValues.get(allValues.size() - 1) + allValues.get(allValues.size() - 2) + allValues.get(allValues.size() - 3);

        System.out.println(max);
        System.out.println(topThree);
    }
}


