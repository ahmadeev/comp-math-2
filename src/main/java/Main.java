import java.util.Scanner;

import static utils.ConsoleInteractions.getInputMode;
import static utils.ConsoleInteractions.getObjectCode;
import static utils.Utils.exit;

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

        int inputMode = getInputMode(input);
        int objectCode = getObjectCode(input, inputMode);

        exit("", input,0);
    }
}