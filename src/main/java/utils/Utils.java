package utils;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Utils {
    public static int getNextInt(Scanner input) {
        int num;
        try {
            num = input.nextInt();
            return num;
        } catch (InputMismatchException e) {
            String errmsg = "Введенная строка не является целым числом!";
            exit(errmsg, input, 1);
            return 0;
        } catch (NoSuchElementException | IllegalStateException e) {
            String errmsg = e.getMessage();
            exit(errmsg, input, 1);
            return 0;
        }
    }

    public static double getNextDouble(Scanner input) {
        double num;
        try {
            num = input.nextDouble();
            return num;
        } catch (InputMismatchException e) {
            String errmsg = "Введенная строка не является числом!";
            exit(errmsg, input, 1);
            return 0;
        } catch (NoSuchElementException | IllegalStateException e) {
            String errmsg = e.getMessage();
            exit(errmsg, input, 1);
            return 0;
        }
    }

    public static void exit(String msg, Scanner input, int exitCode) {
        if (!(msg.trim().equals(""))) {
            System.out.println(msg);
        }
        input.close();
        System.exit(exitCode);
    }

    public static void exit(String msg, int exitCode) {
        if (!(msg.trim().equals(""))) {
            System.out.println(msg);
        }
        System.exit(exitCode);
    }
}
