package leetcode.p0303;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class K {
    class NumArray {
        private final int[] arr;
        private final Map<Pair, Integer> cache = new HashMap<>();

        public NumArray(int[] nums) {
            arr = nums;
        }

        public int sumRange(int left, int right) {
            Pair pair = new Pair(left, right);
            Integer cacheSum = cache.get(pair);
            if (cacheSum != null) {
                return cacheSum;
            }
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += arr[i];
            }
            cache.putIfAbsent(pair, sum);
            return sum;
        }

        private class Pair {
            private final int left;
            private final int right;

            public Pair(int left, int right) {
                this.left = left;
                this.right = right;
            }

            public int getLeft() {
                return left;
            }

            public int getRight() {
                return right;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                Pair pair = (Pair) o;
                return left == pair.left && right == pair.right;
            }

            @Override
            public int hashCode() {
                return Objects.hash(left, right);
            }
        }
    }
}
