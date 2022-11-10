package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    public static String getString(Scanner scanner, String prompt) {
        String st;
        System.out.print(prompt);
        st = scanner.next();
        return st;
    }

    public static int getInt(Scanner scanner, String prompt) {
        int value = 0;
        boolean isValid = false;
        do {
            try {
                System.out.print(prompt);
                value = scanner.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Error. Invalid number. Try again.");
                scanner.nextLine();
            }
        } while (!isValid);
        return value;
    }

    public static float getFloat(Scanner scanner, String prompt) {
        float value = 0.0f;
        boolean isValid = false;
        do {
            try {
                System.out.print(prompt);
                value = scanner.nextFloat();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Error. Invalid number. Try again.");
                scanner.nextLine();
            }
        } while (!isValid);
        return value;
    }

    public static double getDouble(Scanner scanner, String prompt) {
        double value = 0.0;
        boolean isValid = false;
        do {
            try {
                System.out.print(prompt);
                value = scanner.nextDouble();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Error. Invalid number. Try again.");
                scanner.nextLine();
            }
        } while (!isValid);
        return value;
    }
}
