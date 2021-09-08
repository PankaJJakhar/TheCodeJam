package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class LarrysArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array: ");
        String inputString = scanner.nextLine();

        List<Integer> numbersList = new ArrayList<>();
        numbersList = Arrays.stream(inputString.split(" ")).map(Integer::parseInt).collect(toList());

        String result = larrysArray(numbersList);
        System.out.println(result);
    }

    /*
     * Complete the 'larrysArray' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY A as parameter.
     */

    public static String larrysArray(List<Integer> inputArray) {
        int inputArraySize = inputArray.size();

        int inversionCount = 0;

        for (int index = 0; index < inputArraySize; index++) {
            int numberAtIndex = inputArray.get(index);

            for (int nextIndex = index + 1; nextIndex < inputArraySize; nextIndex++) {
                if (numberAtIndex > inputArray.get(nextIndex)) {
                    inversionCount++;
                }
            }
        }

        if (inversionCount % 2 == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
