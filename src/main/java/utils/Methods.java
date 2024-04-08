package utils;

import equations.Equations;
import equations.*;

import static java.lang.Math.abs;
import static java.lang.Math.log;
import static java.util.Objects.isNull;
import static utils.Utils.exit;

public class Methods {

    public class Halving {
        public static void getRoot(double a, double b, double precision, Equations equation) {
            if (isNull(equation) || a == 0 || b == 0 || precision == 0) exit("Неверные входные данные!", 1);

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
                    exit("я усталь", 1);
                }
                counter++;
                System.out.printf("%d.   a = %5.2f   b = %5.2f   x = %5.2f   f(a) = %5.2f   f(b) = %5.2f   |a - b| = %5.2f\n",
                        counter, lowerBoundary, higherBoundary,
                        lowerBoundary + (higherBoundary - lowerBoundary) / 2,
                        lowerBoundaryValue, higherBoundaryValue, abs(lowerBoundary - higherBoundary));
            }
            System.out.println();
            System.out.printf("После %d итераций корень уравнения равен %f с точностью %f.",
                    reps, lowerBoundary + (higherBoundary - lowerBoundary) / 2, precision);
        }
    }

    public class Newton {
        public static void getRoot(double a, double b, double precision, Equations equation) {
            if (isNull(equation) || a == 0 || b == 0 || precision == 0) exit("Неверные входные данные!", 1);

            double previousX = a;
            double previousXValue = equation.getEquationValue(previousX);
            double previousXDerivativeValue = derivative(equation, previousX);
            double x = previousX - previousXValue / previousXDerivativeValue;

            int counter = 0;
            while (abs(previousX - x) > precision && abs(previousXValue) > precision) {
                System.out.printf("%d.   x_i = %5.2f   f(x_i) = %5.2f   f'(x_i) = %5.2f   x_i+1 = %5.2f   | x_i+1 - x_i | = %5.2f\n",
                        counter,
                        previousX,
                        previousXValue,
                        previousXDerivativeValue,
                        x,
                        abs(x - previousX));

                previousX = x;
                previousXValue = equation.getEquationValue(previousX);
                previousXDerivativeValue = derivative(equation, previousX);
                x = previousX - previousXValue / previousXDerivativeValue;
                counter++;

            }

            System.out.printf("%d.   x_i = %5.2f   f(x_i) = %5.2f   f'(x_i) = %5.2f   x_i+1 = %5.2f   | x_i+1 - x_i | = %5.2f\n",
                    counter,
                    previousX,
                    previousXValue,
                    previousXDerivativeValue,
                    x,
                    abs(x - previousX));
            counter++;

            System.out.println();
            System.out.printf("После %d итераций корень уравнения равен %f с точностью %f.",
                    counter, x, precision);

        }
    }

    public static double derivative(Equations equation, double x) {
        if (isNull(equation)) exit("", 1);
        return ((equation.getEquationValue(x + 1.0e-6) - equation.getEquationValue(x)) * 1.0e+6);
    }
}