import equations.EquationOne;
import equations.EquationThree;
import equations.EquationTwo;
import equations.Equations;
import utils.Methods;

import java.util.Scanner;

import static utils.ConsoleInteractions.*;
import static utils.Methods.derivative;
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

/*        Methods.Halving.getRoot(-2, -1, 0.01);
        exit("", input,0);*/

        int inputMode = getInputMode(input);
        int objectCode = getObjectCode(input, inputMode);
        int methodNumber = getMethodNumber(input, inputMode);

/*        if (objectCode == 1 && methodNumber == 1) {
            Methods.Halving.getRoot(-2, -1, 0.01, new EquationOne());
        }*/

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
                default: {
                    exit("ашипка", input,1);
                }
            }

/*            System.out.println(derivative(equation, 2.49));
            exit("", input,0);*/

            System.out.print("Введите нижнюю границу отрезка: ");
            double lowerBoundary = getNextDouble(input);
            System.out.print("Введите верхнюю границу отрезка: ");
            double higherBoundary = getNextDouble(input);
            System.out.print("Введите точность вычисления: ");
            double precision = getNextDouble(input);
            System.out.println();

            switch(methodNumber) {
                case 1: {
                    Methods.Halving.getRoot(lowerBoundary, higherBoundary, precision, equation);
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    break;
                }
                default: {
                    exit("ашипка", input,1);
                }
            }
        } else if (inputMode == 2) {
            //  poka nichego
        } else {
            exit("ашипка", input,1);
        }

        exit("", input,0);
    }
}