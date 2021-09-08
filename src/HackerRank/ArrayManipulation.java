package HackerRank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class ArrayManipulation {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of array: ");
        int n = scanner.nextInt();

        // skip to nextLine
        scanner.nextLine();

        System.out.print("Enter array: ");
        String inputString = scanner.nextLine();

        List<List<Integer>> queries = new ArrayList<>();
        //queries = Arrays.stream(inputString.split(" ")).map(Integer::parseInt).collect(toList());

        long result = arrayManipulation(n, queries);
        System.out.println(result);
    }

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        int queriesSize = queries.size();

        // [0 1 2 3 4 5]
        long[] outputArray = new long[n + 2];

        // Write your code here
        for (int queryNumber = 0; queryNumber < queriesSize; queryNumber++) {
            List<Integer> queryList = queries.get(queryNumber);
            int a = queryList.get(0);
            int b = queryList.get(1);
            int k = queryList.get(2);

            outputArray[a] += k;
            outputArray[b + 1] -= k;
        }

        long maxNumber = 0;
        for (int index = 1; index <= n; index++) {
            outputArray[index + 1] += outputArray[index];

            maxNumber = Math.max(maxNumber, outputArray[index + 1]);
        }

        return maxNumber;
    }
}
