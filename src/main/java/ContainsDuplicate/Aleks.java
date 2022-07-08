package ContainsDuplicate;

public class Aleks {
    public static void main(String[] args) {
        System.out.println(new Aleks().containsDuplicate(new int[]{ 1, 2, 3, 1 }));
    }

    public boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
