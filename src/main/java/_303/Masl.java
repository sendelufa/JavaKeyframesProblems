package _303;

public class Masl {
    class NumArray {
        private final int[] arr;

        public NumArray(int[] nums) {
            arr = nums;
        }

        public int sumRange(int left, int right) {
            return java.util.Arrays.stream(arr, left, right + 1).sum();
        }
    }
}
