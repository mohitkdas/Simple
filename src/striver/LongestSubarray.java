package striver;

import java.util.HashMap;

/**
 * Given an array containing N integers and an integer K.,
 * Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.
 * Example 1:
 * Input :
 * A[] = {10, 5, 2, 7, 1, 9}
 * K = 15
 * Output : 4
 * Explanation:
 * The sub-array is {5, 2, 7, 1}.
 **/

public class LongestSubarray {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 1, 1, 1};
//        int[] arr = new int[] {2, 0, 0, 3};

        int length = prefixSum(arr, arr.length, 3);
        System.out.println(length);
    }

    private static int prefixSum(int[] arr, int N, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int length = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            int key = sum - K;
            if(sum == K) {
                length = Math.max(length, i + 1);
            }
            if (map.containsKey(key)) {
                length = Math.max(length, i - map.get(key));
            }
            if(!map.containsKey(sum))
                map.put(sum, i);
        }
        return length;
    }
}
