package equations;

public class EquationFour extends Equations {
    public static final String EQUATION = "sin(x) - 10 * cos(2x) = 0";
    public EquationFour() {
    }
    @Override
    public double getEquationValue(double x) {
        return (Math.sin(x) - 10 * Math.cos(2 * x));
    }
}