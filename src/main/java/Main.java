import equations.*;
import utils.Methods;

import java.util.Scanner;

import static utils.ConsoleInteractions.*;
import static utils.Utils.exit;
import static utils.Utils.getNextDouble;

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

        int inputMode = getInputMode(input);
        int objectCode = getObjectCode(input, inputMode);
        int methodNumber = getMethodNumber(input, inputMode);

        if (inputMode == 1) {
            Equations equation = null;
            switch(objectCode) {
                case 1: {
                    equation = new EquationOne();
                    break;
                }
                case 2: {
                    equation = new EquationTwo();
                    break;
                }
                case 3: {
                    equation = new EquationThree();
                    break;
                }
                case 4: {
                    equation = new EquationFour();
                    break;
                }
                default: {
                    exit("Выбранного уравнения не существует!", input,1);
                }
            }

            System.out.print("Введите нижнюю границу отрезка: ");
            double lowerBoundary = getNextDouble(input);
            System.out.print("Введите верхнюю границу отрезка: ");
            double higherBoundary = getNextDouble(input);
            System.out.print("Введите точность вычисления: ");
            double precision = getNextDouble(input);
            System.out.println();

            input.close();
            switch(methodNumber) {
                case 1: {
                    Methods.Halving.getRoot(lowerBoundary, higherBoundary, precision, equation);
                    break;
                }
                case 2: {
                    Methods.Newton.getRoot(lowerBoundary, higherBoundary, precision, equation);
                    break;
                }
                case 3: {
                    Methods.Iteration.getRoot(lowerBoundary, higherBoundary, precision, equation);
                    break;
                }
                default: {
                    exit("Выбранного метода решения нелинейного уравнения не существует!", input,1);
                }
            }
        } else if (inputMode == 2) {
            //  poka nichego
        } else {
            exit("Выбранного сценария работы программы не существует!", input,1);
        }

        exit("", input,0);
    }
}