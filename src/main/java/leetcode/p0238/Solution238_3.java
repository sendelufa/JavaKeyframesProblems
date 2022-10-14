package leetcode.p0238;

public class Solution238_3 {

    public int[] productExceptSelf(int[] nums) {
        var left = new int[nums.length];
        var right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            var revers = nums.length - 1 - i;
            right[revers] = right[revers + 1] * nums[revers + 1];
        }
        for (int i = 0; i < nums.length; i++) nums[i] = left[i] * right[i];
        return nums;
    }

}
