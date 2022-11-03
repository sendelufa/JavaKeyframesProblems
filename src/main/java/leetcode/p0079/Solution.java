package leetcode.p0079;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

class Solution {

    /**
     * <p>Задача решена поиском в ширину от найденых букв первого слова,
     * изобилие Stream API и отсутствие ограничений в поиске пути приводит к
     * Time Limit Exceeded при тесте на LeetCode</p>
     */

    public static void main(String[] args) {
        char[][] boardBIGG = {
                { 'A', 'C', 'A', 'A', 'C', 'A' },
                { 'C', 'A', 'A', 'C', 'A', 'A' },
                { 'A', 'B', 'B', 'B', 'A', 'A' } };

        System.out.println(new Solution().exist(boardBIGG, "ACAACA")); //true
        System.out.println(new Solution().exist(boardBIGG, "ACBAACA")); //true
        System.out.println(new Solution().exist(boardBIGG, "D")); //false
        System.out.println(new Solution().exist(boardBIGG, "BAB")); //false
    }

    public boolean exist(char[][] board, String word) {

        Map<Character, List<Point>> coordinatesMap = new HashMap<>();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                Point point = new Point(x, y);
                Optional.ofNullable(coordinatesMap.putIfAbsent(board[y][x],
                                new ArrayList<>(List.of(point))))
                        .ifPresent(list -> list.add(point));
            }
        }

        for (Character c : word.toCharArray()) {
            if (!coordinatesMap.containsKey(c)) {
                return false;
            }
        }

        if (coordinatesMap.get(word.charAt(0)) != null) {
            List<Boolean> booleans = new ArrayList<>();
            for (Point p : coordinatesMap.get(word.charAt(0))) {
                booleans.add(boardR(coordinatesMap, word.substring(1),
                        new ArrayList<>(List.of(p))));
            }

            return booleans.stream().anyMatch(b -> b);
        }

        return false;
    }

    private static boolean boardR(Map<Character, List<Point>> map, String word,
            List<Point> passedPath) {
        if (word.isEmpty()) {
            return true;
        }

        char first = word.charAt(0);
        List<Point> points = map.get(first);

        if (points == null) {
            return false;
        }

        List<Point> neighbors = points.stream()
                .filter(Predicate.not(passedPath::contains))
                .filter(p -> p.isNeighbor(passedPath.get(passedPath.size() - 1)))
                .toList();

        List<Boolean> booleans = new ArrayList<>();
        for (Point p : neighbors) {
            List<Point> newPassedPath = new ArrayList<>(passedPath);
            newPassedPath.add(p);
            booleans.add(boardR(map, word.substring(1), newPassedPath));
        }

        return booleans.stream().anyMatch(b -> b);
    }

    static class Point {
        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isNeighbor(Point p) {
            return Math.abs(p.x - x) == 1 && p.y == y
                    || Math.abs(p.y - y) == 1 && p.x == x;
        }

        @Override
        public boolean equals(Object o) {
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
    }
}
