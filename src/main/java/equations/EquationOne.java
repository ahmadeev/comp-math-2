package equations;

public class EquationOne extends Equations {
    public EquationOne() {
    }
    @Override
    public double getEquationValue(double x) {
        return (Math.pow(x, 3) - x + 4);
    }
}
