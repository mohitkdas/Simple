import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoPointer(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                result[0] = left;
                result[1] = right;
                return result;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        // two pointer approach requires a sorted array
//        int[] nums = {1, 2, 4, 9};
//        int target = 5;
//        int[] result = twoSum.twoPointer(nums, target);
//        System.out.println("[" + result[0] + "," + result[1] + "]");

        // hashmap does not require array to be sorted
        int[] nums = {2, 1, 9, 4};
        int target = 11;
        int[] result = twoSum.hashMap(nums, target);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }

    public int[] hashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (map.containsKey(compliment)) return new int[]{map.get(compliment), i};
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

}
