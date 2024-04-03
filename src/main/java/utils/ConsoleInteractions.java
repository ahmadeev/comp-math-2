package utils;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import exceptions.InvalidInputException;
import static utils.Utils.exit;
import static utils.Utils.getNextInt;

public class ConsoleInteractions {
    public static int getInputMode(Scanner input) {

        System.out.println("""
                Выберите режим работы программы:
                1 -- нелинейное уравнение,
                2 -- система нелинейных уравнений,
                3 -- test mode
                """);

        int inputMode;
        try {
            inputMode = getNextInt(input);
            if (!(inputMode == 1 | inputMode == 2 | inputMode == 3)) {
                throw new InvalidInputException("Такого режима работы программы не существует!");
            }
            return inputMode;
        } catch (InvalidInputException e) {
            String errmsg = e.getMessage();
            exit(errmsg, input, -1);
            return -1;
        }
    }

    public static int getObjectCode(Scanner input, int inputMode) {
        int objectCode;
        switch(inputMode) {
            case 1: {
                System.out.printf("""
                        Выберите уравнение:
                        1. %s,
                        2. %s,
                        3. %s.
                        """, "meow1", "meow2", "meow3");

                try {
                    objectCode = getNextInt(input);
                    if (!(objectCode == 1 | objectCode == 2 | objectCode == 3)) {
                        throw new InvalidInputException("Номер уравнения выбран неверно!");
                    }
                    return objectCode;
                } catch (InvalidInputException e) {
                    String errmsg = e.getMessage();
                    exit(errmsg, input, -1);
                    return -1;
                }
            }
            case 2: {
                System.out.printf("""
                        Выберите систему уравнений:
                        1. %s,
                        2. %s,
                        3. %s.
                        """, "meow1", "meow2", "meow3");

                try {
                    objectCode = getNextInt(input);
                    if (!(objectCode == 1 | objectCode == 2 | objectCode == 3)) {
                        throw new InvalidInputException("Номер системы уравнений выбран неверно!");
                    }
                    return objectCode;
                } catch (InvalidInputException e) {
                    String errmsg = e.getMessage();
                    exit(errmsg, input, -1);
                    return -1;
                }
            }
            case 3: {
                System.out.println("бебебе");
                break;
            }
            default: {
                System.out.println("Выбранного режима не существует или при вводе допущена ошибка!");
            }
        }
        return 0;
    }
}