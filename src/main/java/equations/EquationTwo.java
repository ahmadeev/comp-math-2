package equations;

public class EquationTwo extends Equations {
    public static final String EQUATION = "x^4 + 5 * x^3 + 10 * (x + 5)^2 - x = 0";
    public EquationTwo() {
    }
    @Override
    public double getEquationValue(double x) {
        return (Math.pow(x, 4) + 5 * Math.pow(x, 3) + 10 * Math.pow((x+5), 2) - x);
    }
}
