package HackerRank;

import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.toList;

public class BiggerIsGreater {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array: ");
        String inputString = scanner.nextLine();

        String outputString = biggerIsGreater(inputString);
        System.out.println(outputString);
    }

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     *
     * https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
     */
    public static String biggerIsGreater(String w) {
        // Write your code here
        char[] charArray = w.toCharArray();

        int pivotIndex = 0;
        int pivotValue;

        for (int i = charArray.length - 1; i > 0; i--) {
            int asciiAtI = charArray[i];
            int asciiAtMinus1 = charArray[i - 1];

            if (asciiAtMinus1 < asciiAtI) {
                pivotIndex = i - 1;

                break;
            }
        }

        pivotValue = charArray[pivotIndex];

        int pivotSwapIndex = -1;
        int maxValue = 1000;

        for (int i = pivotIndex + 1; i < charArray.length; i++) {
            int asciiAtI = charArray[i];

            if (asciiAtI > pivotValue && asciiAtI <= maxValue) {
                maxValue = asciiAtI;
                pivotSwapIndex = i;
            }
        }

        // Swap pivot with min value which is greater than pivot.
        if (pivotSwapIndex != -1) {
            char swapChar = charArray[pivotIndex];
            charArray[pivotIndex] = charArray[pivotSwapIndex];
            charArray[pivotSwapIndex] = swapChar;
        }

        // sort the suffix
        for (int i = pivotIndex + 1; i < charArray.length - 1; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                int asciiAtI = charArray[i];
                int asciiAtJ = charArray[j];

                if (asciiAtI > asciiAtJ) {
                    char swapChar = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = swapChar;
                }
            }
        }

        if (w.equalsIgnoreCase(String.valueOf(charArray)) || pivotSwapIndex == -1) {
            return "no answer";
        }

        return String.valueOf(charArray);
    }
}

