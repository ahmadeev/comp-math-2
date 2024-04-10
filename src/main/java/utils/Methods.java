package utils;

import equations.EquationFour;
import equations.Equations;

import static java.lang.Math.abs;
import static java.lang.Math.log;
import static java.util.Objects.isNull;
import static utils.Utils.exit;

public class Methods {

    public static class Halving {
        public static void getRoot(double a, double b, double precision, Equations equation) {
            if (isNull(equation) || precision == 0) exit("Неверные входные данные!", 1);
            if (getNumberOfRoots(equation, a, b) != 1) exit("Уравнение имеет больше одного корня на отрезке или не имеет корней совсем!", 1);

            double lowerBoundary = a;
            double higherBoundary = b;
            double lowerBoundaryValue = equation.getEquationValue(lowerBoundary);
            double higherBoundaryValue = equation.getEquationValue(higherBoundary);
            double center;
            double centerValue;

            int reps = (int) Math.floor(log(abs(a - b) / precision) / log(2)) + 1 ;
            int counter = 0;
            while (counter < reps) {
                center = lowerBoundary + (higherBoundary - lowerBoundary) / 2;
                centerValue = equation.getEquationValue(center);

                if (lowerBoundaryValue < 0 && centerValue >= 0) {
                    higherBoundary = center;
                    higherBoundaryValue = equation.getEquationValue(higherBoundary);
                } else if (centerValue < 0 && higherBoundaryValue >= 0) {
                    lowerBoundary = center;
                    lowerBoundaryValue = equation.getEquationValue(lowerBoundary);
                } else {
                    exit("Что-то пошло не так при решении уравнения!", 1);
                }
                counter++;
                System.out.printf("%d.   a = %5.2f   b = %5.2f   x = %5.2f   f(a) = %5.2f   f(b) = %5.2f   |a - b| = %5.2f\n",
                        counter, lowerBoundary, higherBoundary,
                        lowerBoundary + (higherBoundary - lowerBoundary) / 2,
                        lowerBoundaryValue, higherBoundaryValue, abs(lowerBoundary - higherBoundary));
            }
            System.out.println();
            System.out.printf("После %d итераций корень уравнения равен %f с точностью %f.\n",
                    reps, lowerBoundary + (higherBoundary - lowerBoundary) / 2, precision);
            System.out.printf("Уравнение имеет корни: %s", equation.getExpectedRoots());
        }
    }

    public static class Newton {
        public static void getRoot(double a, double b, double precision, Equations equation) {
            if (isNull(equation) || precision == 0) exit("Неверные входные данные!", 1);
            if (getNumberOfRoots(equation, a, b) != 1) exit("Уравнение имеет больше одного корня на отрезке или не имеет корней совсем!", 1);

            int counter = 0;
            double previousX = a;

            if (equation.getEquationValue(a) * getSecondDerivative(equation, a) > 0) previousX = a;
            else if (equation.getEquationValue(b) * getSecondDerivative(equation, b) > 0) previousX = b;

            double previousXValue = equation.getEquationValue(previousX);
            double previousXDerivativeValue = getDerivative(equation, previousX);
            double x = previousX - previousXValue / previousXDerivativeValue;
            System.out.printf("%d.   x_i = %5.2f   f(x_i) = %5.2f   f'(x_i) = %5.2f   x_i+1 = %5.2f   | x_i+1 - x_i | = %5.2f\n",
                    counter,
                    previousX,
                    previousXValue,
                    previousXDerivativeValue,
                    x,
                    abs(x - previousX));

            while (abs(previousX - x) > precision && abs(previousXValue) > precision) {
                previousX = x;
                previousXValue = equation.getEquationValue(previousX);
                previousXDerivativeValue = getDerivative(equation, previousX);
                x = previousX - previousXValue / previousXDerivativeValue;
                counter++;
                System.out.printf("%d.   x_i = %5.2f   f(x_i) = %5.2f   f'(x_i) = %5.2f   x_i+1 = %5.2f   | x_i+1 - x_i | = %5.2f\n",
                        counter,
                        previousX,
                        previousXValue,
                        previousXDerivativeValue,
                        x,
                        abs(x - previousX));
            }

            System.out.println();
            System.out.printf("После %d итераций корень уравнения равен %f с точностью %f.\n",
                    counter + 1, x, precision);
            System.out.printf("Уравнение имеет корни: %s", equation.getExpectedRoots());
        }
    }

    public static class Iteration {
        public static void getRoot(double a, double b, double precision, Equations equation) {
            if (isNull(equation) || precision == 0) exit("Неверные входные данные!", 1);
            if (getNumberOfRoots(equation, a, b) != 1) exit("Уравнение имеет больше одного корня на отрезке или не имеет корней совсем!", 1);

        }
    }

    public static double getDerivative(Equations equation, double x) {
        if (isNull(equation)) exit("", 1);
        double deltaX = 1.0e-3;
        return ((equation.getEquationValue(x + deltaX) - equation.getEquationValue(x)) / deltaX);
    }

    public static double getSecondDerivative(Equations equation, double x) {
        if (isNull(equation)) exit("", 1);
        double deltaX = 1.0e-3;
        return (equation.getEquationValue(x + deltaX) - 2 * equation.getEquationValue(x) + equation.getEquationValue(x - deltaX))
                / (deltaX * deltaX);
    }

    public static int getNumberOfRoots(Equations equation, double a, double b) {
        int counter = 0;
        double step = 0.01;

        double lowerBoundaryValue = equation.getEquationValue(a);
        a += step;
        double higherBoundaryValue = equation.getEquationValue(a);
        if ((lowerBoundaryValue < 0 && higherBoundaryValue >= 0) || (lowerBoundaryValue >= 0 && higherBoundaryValue < 0))
            counter++;

        while (a <= b) {
            lowerBoundaryValue = higherBoundaryValue;
            higherBoundaryValue = equation.getEquationValue(a);
            if ((lowerBoundaryValue < 0 && higherBoundaryValue >= 0) || (lowerBoundaryValue >= 0 && higherBoundaryValue < 0))
                counter++;

            a += step;
        }

        return counter;
    }
}