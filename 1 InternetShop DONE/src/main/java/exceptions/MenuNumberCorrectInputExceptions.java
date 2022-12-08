package exceptions;

import java.util.Scanner;

public class MenuNumberCorrectInputExceptions {
    public static int menuNumberCorrectInputExceptions(int i) {
        int choice = 0;
        boolean exit = true;
        while (exit) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= i) {
                    exit = false;
                } else {
                    System.out.println("Incorrect input! Number must be in range 0 - " + i);
                }
            } else {
                System.out.println("Incorrect input, number not between 0 - " + i);
            }
        }
        return choice;
    }
}