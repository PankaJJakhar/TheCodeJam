package HackerRank;

import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.toList;

public class SockMerchant {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of array: ");
        int n = scanner.nextInt();

        // skip to nextLine
        scanner.nextLine();

        System.out.print("Enter array: ");
        String inputString = scanner.nextLine();

        List<Integer> integersArray = new ArrayList<>();
        integersArray = Arrays.stream(inputString.split(" ")).map(Integer::parseInt).collect(toList());

        int result = SockMerchant.sockMerchant(n, integersArray);
        System.out.println(result);
    }

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        HashMap<Integer, Boolean> numberToExistenceMap = new HashMap<Integer, Boolean>();

        int pairCount = 0;

        for (int number : ar) {
            if (numberToExistenceMap.containsKey(number)) {
                numberToExistenceMap.remove(number);

                pairCount++;
            } else {
                numberToExistenceMap.put(number, true);
            }
        }

        return pairCount;
    }
}