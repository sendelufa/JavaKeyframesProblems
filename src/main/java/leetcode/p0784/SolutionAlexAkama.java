package leetcode.p0784;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Solution by https://github.com/AlexAkama

public class SolutionAlexAkama {
    public static void main(String[] args) {
        System.out.println(new SolutionAlexAkama().letterCasePermutation("a1bc"));
        System.out.println();
        System.out.println(new SolutionAlexAkama().letterCasePermutation("ABC"));
        System.out.println(new SolutionAlexAkama().letterCasePermutation("123"));
        System.out.println(new SolutionAlexAkama().letterCasePermutation("a1b1c1"));
        System.out.println(new SolutionAlexAkama().letterCasePermutation("abc"));
    }

    /**
     * <p>Используя рекурсию, передаем для старта в метод foo, индекс = 0 и массив
     * символов, предварительно все символы в нижний регистр переведены</p>
     *
     * <p>Добавляем саму строку как один из результатов</p>
     *
     * <p>в методе foo, пока стартовый индекс меньше конца массива, выполняем
     * проход от переданного индекса до конца массива, пропускаем все числовые
     * символы и передаем в новый запуск метода foo, но уже с сдвигом индекса +1.</p>
     *
     * <p>Когда один из вызовов foo, выполнит return, начинается сборка результата.
     * Каждый символ меняется на верхний регистр по индексу i</p>
     *
     * <p>Таким образом меняется строка с конца.</p>
     *
     * <p>Начало: a1bc</p>
     * <ol>
     * <li> a1bc</li>
     * <li> a1bC</li>
     * <li> a1Bc</li>
     * <li> a1BC</li>
     * <li> A1bc</li>
     * <li> A1bC</li>
     * <li> A1Bc</li>
     * <li> A1BC</li>
     * </ol>
     **/
    private List<String> res;

    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        res = new ArrayList<>();
        res.add(String.valueOf(chars));
        foo(0, chars);
        return res;
    }

    private void foo(int start, char[] chars) {
        if (start > chars.length - 1) {
            return;
        }
        for (int i = start; i < chars.length; i++) {
            var c = chars[i];
            if (Character.isDigit(c)) {
                continue;
            }
            foo(i + 1, Arrays.copyOf(chars, chars.length));
            chars[i] = Character.toUpperCase(c);
            res.add(String.valueOf(chars));
        }
    }
}
