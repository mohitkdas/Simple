package Permutation;


// TC -> O(n!) * O(n)
// SC -> no extra space

import java.util.ArrayList;
import java.util.List;

public class Permutation2 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> ans = permute(nums);
        System.out.println(ans);
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }

    private static void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            // copy the ds to ans
            List<Integer> ds = new ArrayList<>();
            for (int num : nums) {
                ds.add(num);
            }
            ans.add(ds);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermute(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }

    private static void swap(int i, int index, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
