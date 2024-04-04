package equations;

public class EquationTwo extends Equations {
    public EquationTwo() {
    }
    @Override
    public double getEquationValue(double x) {
        return (Math.pow(x, 3) - x + 4);
    }
}
