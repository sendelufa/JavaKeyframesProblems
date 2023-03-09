package yandex_contest_2023.b30;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {1, 5, 5, 6, 7, 9};
        int[] b = {5, 0, 0, 5, 7, 4, 9};

        int[] lcs = findLCS(a, b);
        System.out.println(Arrays.toString(lcs));
    }

    public static int[] findLCS(int[] a, int[] b) {
        var m = a.length;
        var n = b.length;
        var matrix = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                matrix[i][j] = a[i - 1] == b[j - 1]
                        ? matrix[i - 1][j - 1] + 1
                        : Math.max(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }

        var result = new int[matrix[m][n]];
        var i = result.length - 1;

        while (matrix[m][n] > 0) {
            if (matrix[m - 1][n] == matrix[m][n - 1]) {
                if (matrix[m - 1][n - 1] + 1 == matrix[m][n])
                    result[i--] = a[m - 1];
                m--;
                n--;
            } else if (matrix[m - 1][n] == matrix[m][n]) m--; else n--;
        }
        return result;
    }
}
