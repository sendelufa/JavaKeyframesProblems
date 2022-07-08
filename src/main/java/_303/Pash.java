package _303;

public class Pash {

    public static void main(String[] args) {
        Pash p = new Pash(new int[]{ -2, 0, 3, -5, 2, -1 });
        System.out.println(p.sumRange(0, 2));
        System.out.println(p.sumRange(2, 5));
        System.out.println(p.sumRange(0, 5));
    }

    private final int[] arr;

    public Pash(int[] nums) {
        arr = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        while (true) {
            sum += arr[left++];
            sum += arr[right--];
            if (right - left == 1) {
                break;
            }
            if (right - left == 2) {
                sum += arr[++left];
                break;
            }
        }
        return sum;
    }
}
