package HackerRank;

import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class MinimumSwaps2 {
    //private static final String

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of array: ");
        int n = scanner.nextInt();

        // skip to nextLine
        scanner.nextLine();

        System.out.print("Enter array: ");
        String inputString = scanner.nextLine();

        int[] integersArray = new int[n];
        integersArray = Arrays.stream(inputString.split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = minimumSwaps(integersArray);
        System.out.println(result);
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swapsCount = 0;

        while (true) {
            int swapIndex1 = -1;
            int swapIndex2 = -1;

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swapIndex1 = i;
                    break;
                }
            }

            if (swapIndex1 == -1) break;

            for (int i = swapIndex1; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    swapIndex2 = i;
                    break;
                }
            }

            if (swapIndex1 == arr.length - 1) break;
            if (swapIndex2 == arr.length - 1) break;

            System.out.println("SwapIndex1: " + swapIndex1);
            System.out.println("SwapIndex2: " + swapIndex2);

            System.out.println("Swap Count: " + swapsCount);

            int swapNum = arr[swapIndex1];
            arr[swapIndex1] = arr[swapIndex2];
            arr[swapIndex2] = swapNum;

            swapsCount++;
        }

        System.out.println("Array: " + arr);

        return swapsCount;
    }
}
