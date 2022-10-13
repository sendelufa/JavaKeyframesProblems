package leetcode.p0238;

import utils.Utils;

public class Solution238 {
    public static void main(String[] args) {
        Utils.printIntArray(new Solution238().productExceptSelf(new int[]{ -10, 2, 3, 4 }));
    }

    /*
    исходный массив: -10, 2, 3, 4
    Решение:
    - в массив right сохраняем все перемноженные значения правее
        числа: 1, -10, -20, -80
    - в массив left сохраняем все перемноженные значения левее
        числа: 24, 12, 4, 1
    - перемножаем right и left
        24 -120 -80 -60
    */

    public int[] productExceptSelf(int[] nums) {
        int[] right = new int[nums.length];
        right[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            right[i] = right[i - 1] * nums[i - 1];
        }

        int[] left = new int[nums.length];
        left[left.length - 1] = 1;

        for (int i = nums.length - 2; i > -1; i--) {
            left[i] = left[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }

        return nums;
    }
}
