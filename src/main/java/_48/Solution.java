package _48;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<int[][]> testCases = List.of(
                new int[][]{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
                new int[][]{ { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } },
                new int[][]{ { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } });


        Solution solution = new Solution();
        testCases.forEach(intArr -> {
            System.out.println("Before:");
            solution.printMatrix(intArr);
            solution.rotate(intArr);
            System.out.println("After:");
            solution.printMatrix(intArr);
            System.out.println();
        });

    }

    public void rotate(int[][] matrix) {
        int buf;
        for (int counter = 0; counter < matrix.length / 2; counter++) {
            for (int i = 0; i < matrix.length - counter * 2 - 1; i++) {
                buf = matrix[counter][counter + i];
                matrix[counter][counter + i] = matrix[matrix.length - 1 - counter - i][counter];
                matrix[matrix.length - 1 - counter - i][counter] =
                        matrix[matrix.length - 1 - counter][matrix.length - 1 - counter - i];
                matrix[matrix.length - 1 - counter][matrix.length - 1 - counter - i] =
                        matrix[counter + i][matrix.length - 1 - counter];
                matrix[counter + i][matrix.length - 1 - counter] = buf;
            }
        }
    }

    public void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%3d ", anInt);
            }
            System.out.println();
        }
    }
}