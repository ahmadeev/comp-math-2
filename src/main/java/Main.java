import equations.EquationOne;
import utils.Methods;

import java.util.Scanner;

import static utils.ConsoleInteractions.*;
import static utils.Utils.exit;

/*  Методы решения нелинейных уравнений:
            Метод половинного деления
            Метод Ньютона
            Метод простой итерации
        Методы решения систем нелинейных уравнений:
            Метод Ньютона
*/
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

/*        Methods.Halving.getRoot(-2, -1, 0.01);
        exit("", input,0);*/

        int inputMode = getInputMode(input);
        int objectCode = getObjectCode(input, inputMode);
        int methodNumber = getMethodNumber(input, inputMode);

        if (objectCode == 1 && methodNumber == 1) {
            Methods.Halving.getRoot(-2, -1, 0.01, new EquationOne());
        }

        exit("", input,0);
    }
}