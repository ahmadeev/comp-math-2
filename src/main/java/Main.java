import equations.*;
import utils.InputData;
import utils.Methods;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

import static utils.ConsoleInteractions.*;
import static utils.Utils.*;

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

        int programmeMode = getProgrammeMode(input);
        int objectCode = getObjectCode(input, programmeMode);
        int methodNumber = getMethodNumber(input, programmeMode);
        int inputMode;

        if (programmeMode == 1) {
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

            double lowerBoundary = 0;
            double higherBoundary = 0;
            double precision = 0;

            inputMode = getInputMode(input);
            switch (inputMode) {
                case 1: {
                    System.out.printf("Выбранное уравнение имеет корни: %s \n\n", equation.getExpectedRoots());
                    System.out.print("Введите нижнюю границу отрезка: ");
                    lowerBoundary = getNextDouble(input);
                    System.out.print("Введите верхнюю границу отрезка: ");
                    higherBoundary = getNextDouble(input);
                    System.out.print("Введите точность вычисления: ");
                    precision = getNextDouble(input);
                    System.out.println();
                    break;
                }
                case 2: {
                    InputData inputData = setViaFile();
                    lowerBoundary = inputData.lowerBoundary();
                    higherBoundary = inputData.higherBoundary();
                    precision = inputData.precision();
                    break;
                }
                default: {
                    exit("Выбранного способа ввода входных данных не существует!", input,1);
                }
            }

            if (lowerBoundary == 0 && higherBoundary == 0 || precision == 0) exit("", input, 1);

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
        } else if (programmeMode == 2) {
            //  poka nichego
        } else {
            exit("Выбранного сценария работы программы не существует!", input,1);
        }

        exit("", input,0);
    }
}