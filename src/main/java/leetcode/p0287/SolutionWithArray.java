package leetcode.p0287;

import utils.Utils;

public class SolutionWithArray {
    public static void main(String[] args) {
        int[] nums1 = { 1, 3, 4, 2, 5, 1 };
        Utils.printIntArray(nums1);
        System.out.println(new SolutionWithArray().findDuplicate(nums1));

        int[] nums2 = { 2, 2, 2, 2 };
        Utils.printIntArray(nums2);
        System.out.println(new SolutionWithArray().findDuplicate(nums2));
    }

    public int findDuplicate(int[] nums) {
        boolean[] holes = new boolean[nums.length - 1];

        for (int i : nums) {
            if (holes[i - 1]) {
                return i;
            }
            holes[i - 1] = true;
        }
        return -1;
    }
}
