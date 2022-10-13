package leetcode.p0724;

class Solution {
    public int pivotIndex(int[] nums) {
        int rSum = 0;
        for (int num : nums) {
            rSum += num;
        }

        int lSum = 0;

        for(int i = 0; i < nums.length; i++){
            rSum -= nums[i];
            lSum += nums[i];
            if (lSum - rSum == nums[i])
                return i;
        }
        return -1;
    }
}

/*
28 27 20 17 11
 0  1  8 11 17
*/
