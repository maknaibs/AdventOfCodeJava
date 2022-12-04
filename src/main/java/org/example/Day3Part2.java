package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/input.txt"));

        int sum = 0;
        ArrayList<String> strings = new ArrayList<>();
        while (scanner.hasNextLine()) {
            if (strings.size() < 4) {
                String line = scanner.nextLine();
                strings.add(line);
            }
            if (strings.size() == 3) {
                String string1 = strings.get(0);
                String string2 = strings.get(1);
                String string3 = strings.get(2);
                char commonChar = 0;

                commonChar = getCommonChar(string1, string2, string3, commonChar);
                sum = Day3.getSum(sum, commonChar);
                strings.clear();
            }
        }
        System.out.println(sum);
    }

    private static char getCommonChar(String string1, String string2, String string3, char commonChar) {
        for (int i = 0; i < string1.length(); i++) {
            for (int j = 0; j < string2.length(); j++) {
                for (int k = 0; k < string3.length(); k++) {
                    if (string1.charAt(i) == string2.charAt(j) && string2.charAt(j) == string3.charAt(k)) {
                        commonChar = string1.charAt(i);
                        break;
                    }
                }
            }
        }
        return commonChar;
    }
}