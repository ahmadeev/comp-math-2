package utils;

import equations.Equations;
import equations.*;

import static java.lang.Math.abs;
import static java.lang.Math.log;
import static utils.Utils.exit;

public class Methods {

    public class Halving {
        public static void getRoot(double a, double b, double precision, Equations equation) {
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

                if (lowerBoundaryValue < 0 && centerValue > 0) {
                    higherBoundary = center;
                    higherBoundaryValue = equation.getEquationValue(higherBoundary);
                } else if (centerValue < 0 && higherBoundaryValue > 0) {
                    lowerBoundary = center;
                    lowerBoundaryValue = equation.getEquationValue(lowerBoundary);
                } else {
                    exit("я усталь", 1);
                }
                counter++;
                System.out.printf("a = %5.2f   b = %5.2f   x = %5.2f   f(a) = %5.2f   f(b) = %5.2f   |a - b| = %5.2f\n",
                        lowerBoundary, higherBoundary,
                        lowerBoundary + (higherBoundary - lowerBoundary) / 2,
                        lowerBoundaryValue, higherBoundaryValue, abs(lowerBoundary - higherBoundary));
            }
            System.out.printf("После %d итераций корень уравнения равен %f с точностью %f.",
                    reps, lowerBoundary + (higherBoundary - lowerBoundary) / 2, precision);
        }
    }
}