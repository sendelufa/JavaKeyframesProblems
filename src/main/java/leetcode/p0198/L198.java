package leetcode.p0198;

import utils.Utils;

public class L198 {

    public static void main(String[] args) {
        Utils.printIntArray(new Integer[]{ 2, 7, 1, 1, 90, 1, 1 });
        System.out.println(new L198().rob(new int[]{ 1, 1, 4, 1, 1 }));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < nums.length; i++) {
            int sumRobbed = Math.max(nums[i - 2],
                    i - 3 < 0 ? -1 : nums[i - 3]);
            nums[i] += sumRobbed;
        }

        return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
    }
}
