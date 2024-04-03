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
            exit(errmsg, input, -1);
            return -1;
        } catch (NoSuchElementException | IllegalStateException e) {
            String errmsg = e.getMessage();
            exit(errmsg, input, -1);
            return -1;
        }
    }

    public static void exit(String msg, Scanner input, int exitCode) {
        if (!(msg.trim().equals(""))) {
            System.out.println(msg);
        }
        input.close();
        System.exit(exitCode);
    }
}
