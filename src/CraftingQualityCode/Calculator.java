package CraftingQualityCode;

import java.util.Scanner;

public class Calculator {
    private static final String OPERATOR_PLUS = "+";
    private static final String OPERATOR_MINUS = "-";

    private static double firstNumber;
    private static double secondNumber;
    private static double result;

    private static String operation;

    public static void main(String[] args) {
        runProgram();
    }

    public static void runProgram() {
        // reads the user input.
        readInput();

        // perform the requested operation.
        executeOperation();

        // give back result.
        printResult();
    }

    private static void readInput() {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        firstNumber = inputScanner.nextDouble();

        System.out.print("Enter second number: ");
        secondNumber = inputScanner.nextDouble();

        System.out.print("Enter operation: ");
        operation = inputScanner.next();
    }

    private static void executeOperation() {
        switch (operation) {
            case OPERATOR_PLUS:
                result = firstNumber + secondNumber;
                break;
            case OPERATOR_MINUS:
                result = firstNumber - secondNumber;
        }
    }

    public static void printResult() {
        System.out.println("Result: " + String.format("%.2f", result));
    }
}
