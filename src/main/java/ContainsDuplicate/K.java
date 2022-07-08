package ContainsDuplicate;

import java.util.Arrays;

public class K {
    public static void main(String[] args) {
        System.out.println(new K().containsDuplicate(new int[]{ 1, 2, 3, 1 }));
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1) {
            return false;
        }

        Arrays.sort(nums);
        int c = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == c) {
                return true;
            }
            c = nums[i];
        }
        return false;
    }
}
