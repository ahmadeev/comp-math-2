package equations;

public class EquationThree extends Equations {
    public static final String EQUATION = "meow3";
    public EquationThree() {
    }
    @Override
    public double getEquationValue(double x) {
        return (Math.pow(x, 3) - x + 4);
    }
}
