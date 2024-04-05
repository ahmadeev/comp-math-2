package equations;

public class EquationTwo extends Equations {
    public static final String EQUATION = "x^3 + x^2 + x = 0";
    public EquationTwo() {
    }
    @Override
    public double getEquationValue(double x) {
        return (Math.pow(x, 3) + Math.pow(x, 2) + x);
    }
}
