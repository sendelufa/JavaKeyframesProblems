package range_sum.duplicate;

public class Aleks {
    public static void main(String[] args) {
        System.out.println();
    }

    class NumArray {
        private final int[] arr;

        public NumArray(int[] nums) {
            arr = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += arr[i];
            }
            return sum;
        }
    }
}
