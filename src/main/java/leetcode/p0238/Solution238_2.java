package leetcode.p0238;

import utils.Utils;

public class Solution238_2 {
    public static void main(String[] args) {
        Utils.printIntArray(new Solution238_2().productExceptSelf(new int[]{ -10, 2, 3, 4 }));
    }

    /*
    исходный массив: -10, 2, 3, 4

    Решение:
    - в массив left сохраняем все перемноженные значения левее
        числа: 24, 12, 4, 1
    - в переменную right сохраняем накопленное перемножение справа чисел
        числа: 1, -10, -20, -80
      тут же умножаем каждый элемент на соотв. в массиве left
    */

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[left.length - 1] = 1;

        for (int i = nums.length - 2; i > -1; i--) {
            left[i] = left[i + 1] * nums[i + 1];
        }

        int right = 1;

        for (int i = 1; i < nums.length; i++) {
            right *= nums[i - 1];
            left[i] *= right;
        }

        return left;
    }
}
