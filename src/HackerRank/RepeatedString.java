package HackerRank;

import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: ");
        String str = scanner.nextLine();

        scanner.nextLine();

        System.out.print("Enter length: ");
        long len = scanner.nextInt();

        long result = repeatedString(str, len);
        System.out.println("Result: " + result);
    }

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */
    public static long repeatedString(String s, long n) {
        // Write your code here
        long lengthOfStr = s.length();
        long requestedCharInStr = 0;

        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (c == 'a') {
                requestedCharInStr++;
            }
        }

        long repeatArrayTimes = (long) (n / lengthOfStr);
        long remainingChars = (long) n % lengthOfStr;
        long resultCount = repeatArrayTimes * requestedCharInStr;

        long stringLengthCount = 0;

        if (remainingChars > 0) {
            for (char c : charArray) {
                stringLengthCount++;

                if (c == 'a') {
                    resultCount++;
                }

                if (stringLengthCount >= remainingChars) {
                    break;
                }
            }
        }

        return resultCount;
    }
}
