package lab1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShortestStringSearcher {

   public String[] input() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Введите число строк:");
        int StringsCount = 0;
        try {
            StringsCount = reader.nextInt();
        } catch (InputMismatchException fg) {
            System.out.print("Вы ввели не число. ");
        }

        String[] currentStrings = new String[StringsCount];
        Scanner sc2 = new Scanner(System.in);
        for (int i = 0; i < StringsCount; i++) {
            System.out.println("Введите строку номер " + (i + 1));
            currentStrings[i] = sc2.nextLine();
        }
        return currentStrings;
    }

    public String ShortestLine(String[] currentStrings) {
        String veryShortString = currentStrings[0];
        for (int i = 1; i < currentStrings.length; i++) {
            if (currentStrings[i].length() < veryShortString.length()) {
                veryShortString = currentStrings[i];
            }
        }
        return veryShortString;
    }

    public void output(String veryShortString) {
        System.out.println("Самая короткая строка = " + veryShortString);
        System.out.println("Ее длина равна " + veryShortString.length());
    }

}
