package HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size on input: ");
        int steps = scanner.nextInt();

        // skip to nextLine
        scanner.nextLine();

        System.out.print("Enter input: ");
        String path = scanner.nextLine();

        int result = countingValleys(steps, path);
        System.out.println("Result: " + result);
    }

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */
    public static int countingValleys(int steps, String path) {
        // Write your code here
        char charUp = 'U';
        char charDown = 'D';

        int valleyResetCount = 0;

        int pathIndex = 0;
        int oldPathIndex = 0;

        for (char c : path.toCharArray()) {
            if (c == charDown) {
                pathIndex--;
            } else {
                pathIndex++;
            }

            if (oldPathIndex == 0 && pathIndex == -1) {
                valleyResetCount++;
            }

            oldPathIndex = pathIndex;
        }


        return valleyResetCount;
    }
}
