package leetcode.p0287;

import utils.Utils;

import java.util.HashSet;
import java.util.Set;

public class SolutionWithSet {
    public static void main(String[] args) {
        int[] nums1 = { 1, 3, 4, 2, 5, 1 };
        Utils.printIntArray(nums1);
        System.out.println(new SolutionWithSet().findDuplicate(nums1));

        int[] nums2 = { 2, 2, 2, 2 };
        Utils.printIntArray(nums2);
        System.out.println(new SolutionWithSet().findDuplicate(nums2));
    }

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i: nums){
            if(!set.add(i))
                return i;
        }
        return -1;
    }
}
