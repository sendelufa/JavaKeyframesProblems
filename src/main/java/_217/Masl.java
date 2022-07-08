package _217;

import java.util.HashMap;
import java.util.Map;

public class Masl {
    public static void main(String[] args) {
        System.out.println(new Masl().containsDuplicate(new int[]{ 1, 2, 3, 1 }));
    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int d = nums[i];
            if (map.get(d) == null) {
                map.put(d, 1);
            } else {
                return true;
            }
        }
        return false;
    }
}
