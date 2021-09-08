package CodingTechniques;

import java.util.HashMap;

/*
 * Fibonacci sequence = 1, 1, 2, 3, 5, 8, 13, 21 and so on...
 *
 * f(n) = f(n - 1) + f(n - 2)
 *
 */
public class Memoization {
    private static int executionStepsCount = 0;

    private static HashMap<Integer, Integer> numberToResultMap = new HashMap<>();

    public static void main(String[] args) {
        int index = 5;

        int numberAtIndex = findFibonacciNumber(index);
        System.out.println("Number is: " + numberAtIndex);
        System.out.println("Execution steps count: " + executionStepsCount);

        executionStepsCount = 0;
        numberAtIndex = findFibonacciNumberWithMemoization(index);
        System.out.println("Number is: " + numberAtIndex);
        System.out.println("Execution steps count: " + executionStepsCount);
    }

    private static int findFibonacciNumber(int index) {
        executionStepsCount++;

        if (index == 0 || index == 1) return 1;

        return findFibonacciNumber(index - 1) + findFibonacciNumber(index - 2);
    }

    private static int findFibonacciNumberWithMemoization(int index) {
        executionStepsCount++;

        if (index == 0 || index == 1) return 1;

        if (numberToResultMap.containsKey(index)) {
            return numberToResultMap.get(index);
        } else {
            int sum = findFibonacciNumberWithMemoization(index - 1) + findFibonacciNumberWithMemoization(index - 2);

            numberToResultMap.put(index, sum);

            return sum;
        }
    }
}
