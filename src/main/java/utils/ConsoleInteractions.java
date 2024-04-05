package utils;

import java.util.Scanner;

import equations.EquationOne;
import equations.EquationThree;
import equations.EquationTwo;
import exceptions.InvalidInputException;

import static utils.Utils.*;

public class ConsoleInteractions {
    public static int getInputMode(Scanner input) {

        System.out.println("""
                Выберите режим работы программы:
                1 -- нелинейное уравнение,
                2 -- система нелинейных уравнений,
                """);
        System.out.print("Выберите номер режима: ");
        int inputMode;
        try {
            inputMode = getNextInt(input);
            System.out.println();
            if (!(inputMode == 1 | inputMode == 2)) {
                throw new InvalidInputException("Такого режима работы программы не существует!");
            }
            return inputMode;
        } catch (InvalidInputException e) {
            String errmsg = e.getMessage();
            exit(errmsg, input, 1);
            return -1;
        }
    }

    public static int getObjectCode(Scanner input, int inputMode) {
        int objectCode;
        switch(inputMode) {
            case 1: {
                System.out.printf("""
                        Выберите уравнение:
                        1. ( %s ),
                        2. ( %s ),
                        3. ( %s ).
                        \n""", EquationOne.EQUATION, EquationTwo.EQUATION, EquationThree.EQUATION);
                System.out.print("Выберите номер уравнения: ");
                try {
                    objectCode = getNextInt(input);
                    System.out.println();
                    if (!(objectCode == 1 | objectCode == 2 | objectCode == 3)) {
                        throw new InvalidInputException("Номер уравнения выбран неверно!");
                    }
                    return objectCode;
                } catch (InvalidInputException e) {
                    String errmsg = e.getMessage();
                    exit(errmsg, input, 1);
                    return -1;
                }
            }
            case 2: {
                System.out.println("""
                        Выберите систему уравнений:
                        1. -,
                        2. -,
                        3. -.
                        """);
                System.out.print("Выберите номер системы уравнений: ");
                try {
                    objectCode = getNextInt(input);
                    System.out.println();
                    if (!(objectCode == 1 | objectCode == 2 | objectCode == 3)) {
                        throw new InvalidInputException("Номер системы уравнений выбран неверно!");
                    }
                    return objectCode;
                } catch (InvalidInputException e) {
                    String errmsg = e.getMessage();
                    exit(errmsg, input, 1);
                    return -1;
                }
            }
            default: {
                System.out.println("Выбранного режима не существует или при вводе допущена ошибка!");
            }
        }
        return 0;
    }

    public static int getMethodNumber(Scanner input, int inputMode) {
        int methodNumber;
        switch(inputMode) {
            case 1: {
                System.out.println("""
                        Выберите метод решения уравнения:
                        1. Метод половинного деления,
                        2. Метод Ньютона,
                        3. Метод простой итерации.
                        """);
                System.out.print("Выберите номер метода: ");
                try {
                    methodNumber = getNextInt(input);
                    System.out.println();
                    if (!(methodNumber == 1 | methodNumber == 2 | methodNumber == 3)) {
                        throw new InvalidInputException("Номер метода выбран неверно!");
                    }
                    return methodNumber;
                } catch (InvalidInputException e) {
                    String errmsg = e.getMessage();
                    exit(errmsg, input, 1);
                    return -1;
                }
            }
            case 2: {
                System.out.println("Для решения системы уравнений используется метод Ньютона.");
                break;
            }
            default: {
                System.out.println("Выбранного режима не существует или при вводе допущена ошибка!");
            }
        }
        return 0;
    }

/*    public static double getBoundary(Scanner input) {
        double boundary;
        boundary = getNextDouble(input);
        return boundary;
    }*/
}