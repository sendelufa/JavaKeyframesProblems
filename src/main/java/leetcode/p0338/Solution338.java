package leetcode.p0338;

import java.util.Arrays;

public class Solution338 {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(new Solution338().countBits(i)));
        }

    }

    public int[] countBits(int n) {
        if (n == 0) return new int[1];

        int[] result = new int[n + 1];
        int lastCursor = 1;

        for (int i = 1; i <= n; i++) {
            if (lastCursor << 1 == i) lastCursor = lastCursor << 1;
            result[i] = result[i - lastCursor] + 1;
        }

        return result;
    }
}
    /*
    Суть решения, в переиспользовании предыдущих результатов
    на каждом этапе мы записываем последний индекс где была
    ровно степень двойки (lastCursor) и на это значение мы смотрим назад
    и суммируем значение добавляя всегда еденицу в начале числа

         0 --> 0   0000 <---------|
         1 --> 1   0001     2^0   |
    |--> 2 --> 1   0010     2^1---| 0+1
    |    3 --> 2   0011
    |    4 --> 1   0100     2^2
    |    5 --> 2   0101
    |    6 --> 2   0110
    |    7 --> 2   0111
    |    8 --> 1   1000    2^3
    |    9 --> 2   1001
    |---10 --> 2   1010    1+1
        11 --> 3   1011
        12 --> 2   1100
        13 --> 3   1101
        14 --> 3   1110
        15 --> 4   1111
        16 --> 1  10000     2^4

    */