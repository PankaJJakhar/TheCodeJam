package HackerRank;

import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.toList;

public class JumpingOnClouds {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of array: ");
        int n = scanner.nextInt();

        // skip to nextLine
        scanner.nextLine();

        System.out.print("Enter array: ");
        String inputString = scanner.nextLine();

        List<Integer> numbersList = new ArrayList<>();
        numbersList = Arrays.stream(inputString.split(" ")).map(Integer::parseInt).collect(toList());
        //System.out.println(numbersList);
        int result = jumpingOnClouds(numbersList);
        System.out.println(result);
    }


    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */
    public static int jumpingOnClouds(List<Integer> numbersList) {
        // Write your code here
        int jumpsCount = 0;
        int numbersListSize = numbersList.size();

        Boolean isJumped = false;

        for (int index = 0; index < numbersListSize;) {
            if (isJumped) {
                jumpsCount++;
                isJumped = false;
            }

            if (numbersList.get(index) == 0) {
                if (index + 2 <= numbersListSize - 1) {
                    index += 2;
                } else {
                    index += 1;
                }

                isJumped = true;
            } else {
                index -= 1;
                isJumped = false;
            }
        }

        return jumpsCount;
    }

}
