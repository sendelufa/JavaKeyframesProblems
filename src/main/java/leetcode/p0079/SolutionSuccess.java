package leetcode.p0079;

class SolutionSuccess {
    public static void main(String[] args) {
        char[][] boardBIGG = {
                { 'A', 'C', 'A', 'A', 'C', 'A' },
                { 'C', 'A', 'A', 'C', 'A', 'A' },
                { 'A', 'B', 'B', 'B', 'A', 'A' } };

        System.out.println(new SolutionSuccess().exist(boardBIGG, "ACAACA")); //true
        System.out.println(new SolutionSuccess().exist(boardBIGG, "ACBAACA")); //true
        System.out.println(new SolutionSuccess().exist(boardBIGG, "D")); //false
        System.out.println(new SolutionSuccess().exist(boardBIGG, "BAB")); //false
    }

    /**
     * <p>Суть метода в поиске маршрута используя рекурсию, которая для каждой ячейки пытается построить
     * маршрут, в каждый цикл рекурсия пытается строить маршрут, закрывая пройденный путь символом #</p>
     *
     * <p>Когда рекурсия схлопывается, то восстанавливает путь, возвращая на места # символ, который стоял до замены
     * .</p>
     *
     * <p><code>
     * { '#', '#', 'A', 'C', 'C', 'A' }<br>
     * { 'C', '#', '#', '#', 'A', 'A' }<br>
     * { 'A', 'B', 'B', 'B', 'A', 'A' }
     * </code></p>
     *
     * <p>Если мы смогли построить путь длиной в переданное слово - то сразу возвращаем true и завершаем работу.</p>
     */

    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        boolean result = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return result;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int wordPos) {

        if (wordPos == word.length()) {
            return true;
        }

        // проверка выхода за границы, и если текущая буква поля не равна букве в слове
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(wordPos)) {
            return false;
        }

        char temp = board[i][j];

        board[i][j] = '#';

        boolean result = (dfs(board, word, i - 1, j, wordPos + 1)
                || dfs(board, word, i + 1, j, wordPos + 1)
                || dfs(board, word, i, j - 1, wordPos + 1)
                || dfs(board, word, i, j + 1, wordPos + 1));

        // restore from `#`
        board[i][j] = temp;

        return result;
    }
}

