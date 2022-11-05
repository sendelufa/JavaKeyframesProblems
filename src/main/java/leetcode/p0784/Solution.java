package leetcode.p0784;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().letterCasePermutation("a1bc"));
        System.out.println(new Solution().letterCasePermutation("ABC"));
        System.out.println(new Solution().letterCasePermutation("123"));
        System.out.println(new Solution().letterCasePermutation("a1b1c1"));
        System.out.println(new Solution().letterCasePermutation("abc"));
    }

    /**
     * <p>Создаем массив индексов букв в строке
     * для "a1bc" indexes = [0,2,3]</p>
     *
     * <p>Количество элементов в результирующем списке = indexes^2
     * количество букв ^ вариантов букв (нижний + верхний регистр)</p>
     *
     * <p>Проходим всё количество возможных элементов
     * <code>i = 0,1,2,3,4,5,6,7,8</code></p>
     *
     * <p>И меняем каждый символ по правилу - если итерация делится на индекс в
     * степени двойки без остатка. Таким образом первая буква меняется через раз,
     * вторая буква через два раза, третья через четыре раза и тд.</p>
     *
     * <p>Начало: a1bc</p>
     * <ol>
     * <li> A1BC</li>
     * <li> a1BC</li>
     * <li> A1bC</li>
     * <li> a1bC</li>
     * <li> A1Bc</li>
     * <li> a1Bc</li>
     * <li> A1bc</li>
     * <li> a1bc</li>
     * </ol>
     **/
    public List<String> letterCasePermutation(String s) {
        char[] lc = s.toCharArray();

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < lc.length; i++) {
            if (Character.isLetter(lc[i])) {
                indexes.add(i);
            }
        }

        int countOfVariants = 1 << indexes.size();
        List<String> result = new ArrayList<>(countOfVariants);
        for (int i = 0; i < countOfVariants; i++) {
            for (int index = 0; index < indexes.size(); index++) {
                //остаток от деления - медленная операция в этом решении
                if (i % (1 << index) == 0) {
                    int currentCharIndex = indexes.get(index);
                    lc[currentCharIndex] = Character.isLowerCase(lc[currentCharIndex])
                            ? Character.toUpperCase(lc[currentCharIndex])
                            : Character.toLowerCase(lc[currentCharIndex]);
                }
            }
            result.add(new String(lc));
        }
        return result;
    }
}
