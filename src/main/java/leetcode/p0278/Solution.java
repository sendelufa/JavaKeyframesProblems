package leetcode.p0278;

public class Solution {

    private static final int BAD = 5;

    public int firstBadVersion(int n) {
        if (n == 1) return 1;
        return find(1, n);

        // 123456789  1-9  1+(9-1)/2 = 5    1-4 5-9
        // ----+++++
        //    ^
        // 123456789  5-9  5+(9-5)/2 = 7  5-7
        //     +++++
        //       ^
        // 123456789  5-7  5+(7-5)/2 = 6  5-6 7-7
        //     +++
        //      ^
        // 123456789  5-6  5+(6-5)/2 = 5
        //     ++
        //     ^      midle = start => return
    }

    //Runtime: 20 ms, faster than 52.70% of Java online submissions for First Bad Version.
    //Memory Usage: 41.1 MB, less than 26.56% of Java online submissions for First Bad Version.
    private int find(int start, int finish) {
        int middle = start + (finish - start) / 2;
        if (finish == start) return finish;
        if (isBadVersion(middle)) {
            return find(start, middle);
        } else {
            return find(middle + 1, finish);
        }
    }

    boolean isBadVersion(int index) {
        return index >= BAD;
    }

    //Runtime: 18 ms, faster than 62.95% of Java online submissions for First Bad Version.
    //Memory Usage: 40.9 MB, less than 49.36% of Java online submissions for First Bad Version.
    public int firstBadVersion2(int n) {
        int start = 1;
        int finish = n;
        int middle;
        while (start != finish) {
            middle = start + (finish - start) / 2;
            if (isBadVersion(middle)) {
                finish = middle;
            } else {
                start = middle + 1;
            }
        }
        return start;
    }

}
