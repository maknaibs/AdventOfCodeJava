package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/input.txt"));

        int sum = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String string1 = line.substring(0, line.length() / 2);
            String string2 = line.substring(line.length() / 2);
            char commonChar = 0;

            for (int i = 0; i < string1.length(); i++) {
                for (int j = 0; j < string2.length(); j++) {
                    if (string1.charAt(i) == string2.charAt(j)) {
                        commonChar = string1.charAt(i);
                        break;
                    }
                }
            }
            sum = getSum(sum, commonChar);
        }

        System.out.println(sum);
        
    }

    static int getSum(int sum, char commonChar) {
        int commonCharValue = 0;
        if (commonChar >= 'a' && commonChar <= 'z') {
            commonCharValue = commonChar - 'a' + 1;
        } else if (commonChar >= 'A' && commonChar <= 'Z') {
            commonCharValue = commonChar - 'A' + 27;
        }
        sum += commonCharValue;
        return sum;
    }
}