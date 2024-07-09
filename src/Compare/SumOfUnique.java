package Compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SumOfUnique {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, 3);

        System.out.println(sumOfUnique(list));
    }

    private static int sumOfUnique(List<Integer> arr) {
        Collections.sort(arr);
        int prev = arr.get(0);

        int sum = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            int curr = arr.get(i);

            if (prev == curr) {
                curr = prev + 1;
            }
            sum += curr;
            prev = curr;
        }
        return sum;
    }
}
