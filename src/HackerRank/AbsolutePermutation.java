package HackerRank;

import java.util.*;

public class AbsolutePermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        System.out.print("Enter k: ");
        int k = scanner.nextInt();

        List<Integer> resultList = absolutePermutation(n, k);
        System.out.println(resultList);
    }

    /*
     * Test Case:
     * n = 100, k = 2
     *
     * Result:
     * Indices: 1 2 3 4     5 6 7 8     9  10 11 12      and so on...
     * Values : 3 4 1 2     7 8 5 6     11 12  9 10      and so on...
     *
     * Follow |pos[i] - i| = k
     * At index = 1, |pos[1] - 1| = 2 >>  |3 - 1| = 2
     * At index = 2, |pos[2] - 2| = 2 >>  |4 - 2| = 2
     * At index = 3, |pos[3] - 3| = 2 >>  |1 - 3| = 2
     * At index = 4, |pos[4] - 4| = 2 >>  |2 - 4| = 2
     *
     *
     * 3 4 1 2
     * 7 8 5 6
     * 11 12 9 10
     * and so on...
     *
     * Complete the 'absolutePermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     */
    public static List<Integer> absolutePermutation(int n, int k) {
        // Write your code here
        List<Integer> inputList = new ArrayList<>();
        inputList.add(-1);

        if (k != 0 && ((n / 2) % k) != 0) {
            return inputList;
        }

        int substitute = k;

        // Initialising 2 * k places.
        // substitute number is used so that we don't tamper k's value.
        // Achieving |pos[i] - i| = k
        for (int index = 1; index < 2 * k + 1; index++) {
            inputList.add(index, index + substitute);

            if (inputList.get(index) == 2 * k && index <= n + 1) {
                substitute -= (2 * substitute);
            }
        }

        // Repeating (2 * k) places' value again and again by adding
        // previously calculated value at [index - 2 * k]
        int targetIndex;
        for (int index = (2 * k + 1); index < n + 1; index++) {
            if ((2 * k) == 0) {
                inputList.add(index, index);
            } else {
                targetIndex = index - (2 * k);

                inputList.add(index, inputList.get(targetIndex) + (2 * k));
            }
        }

        // If we reached this far, then we don't need -1 at index 0.
        inputList.remove(0);

        return inputList;
    }
}
