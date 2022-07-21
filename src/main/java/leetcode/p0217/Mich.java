package leetcode.p0217;

import java.util.HashSet;
import java.util.Set;

public class Mich {
    public static void main(String[] args) {
        System.out.println(new Mich().containsDuplicate(new int[]{ 1, 2, 3, 1 }));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicates = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!duplicates.add(nums[i])) {
                return true;
            }
        }
        return nums.length != duplicates.size();
    }
}
