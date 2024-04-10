package utils;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Utils {
    public static int getNextInt(Scanner input) {
        int num;
        try {
            num = input.nextInt();
            return num;
        } catch (InputMismatchException e) {
            String errmsg = "Введенная строка не является целым числом!";
            exit(errmsg, input, 1);
            return 0;
        } catch (NoSuchElementException | IllegalStateException e) {
            String errmsg = e.getMessage();
            exit(errmsg, input, 1);
            return 0;
        }
    }

    public static double getNextDouble(Scanner input) {
        double num;
        try {
            num = input.nextDouble();
            return num;
        } catch (InputMismatchException e) {
            String errmsg = "Введенная строка не является числом!";
            exit(errmsg, input, 1);
            return 0;
        } catch (NoSuchElementException | IllegalStateException e) {
            String errmsg = e.getMessage();
            exit(errmsg, input, 1);
            return 0;
        }
    }

    public static InputData setViaFile() {
        Scanner input = new Scanner(System.in);
        String pathExample = "C:\\Users\\danis\\OneDrive\\Рабочий стол\\untitled\\src\\main\\resources\\file.txt";
        System.out.println("Введите путь к файлу в формате\n" + pathExample);
        String path = input.nextLine();
        try(FileInputStream reader = new FileInputStream(path)) {

            String file = IOUtils.toString(reader);
            String[] fileSeparatedByNewline = file.split("\n");

            double lowerBoundary = Double.parseDouble(fileSeparatedByNewline[0]);
            double higherBoundary = Double.parseDouble(fileSeparatedByNewline[1]);
            double precision = Double.parseDouble(fileSeparatedByNewline[2]);

            reader.close();
            return new InputData(lowerBoundary, higherBoundary, precision);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new InputData(0, 0, 0);
        }
    }

    public static void exit(String msg, Scanner input, int exitCode) {
        if (!(msg.trim().equals(""))) {
            System.out.println(msg);
        }
        input.close();
        System.exit(exitCode);
    }

    public static void exit(String msg, int exitCode) {
        if (!(msg.trim().equals(""))) {
            System.out.println(msg);
        }
        System.exit(exitCode);
    }
}
