package baekjoon.bfs._2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] g = new int[arr[0]][arr[1]];
        int[][] rec = new int[arr[2]][4];
        boolean[][] visit = new boolean[arr[0]][arr[1]];
        for (int i = 0; i < arr[2]; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                rec[i][j] = Integer.parseInt(s[j]);
            }
        }
        initialRec(g, rec);
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (!visit[i][j] && g[i][j] == 0) {
                    answers.add(area(g, i, j, visit));
                }
            }
        }
        System.out.println(answers.size());
        System.out.println(
                answers.stream()
                        .sorted(Comparator.naturalOrder())
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))
        );
    }

    private static void initialRec(int[][] g, int[][] rec) {
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                g[i][j] = checkRec(rec, i, j);
            }
        }
    }

    private static int checkRec(int[][] rec, int x, int y) {
        for (int[] ints : rec) {
            int x1 = ints[1];
            int y1 = ints[0];
            int x2 = ints[3];
            int y2 = ints[2];
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    if (x == k && y == j) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    private static int area(int[][] g, int x, int y, boolean[][] visit) {
        visit[x][y] = true;
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        answer++;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int a = poll[0];
            int b = poll[1];
            // 상
            if (a - 1 >= 0 && !visit[a - 1][b] && g[a - 1][b] == 0) {
                answer++;
                visit[a - 1][b] = true;
                queue.add(new int[]{a - 1, b});
            }
            // 하
            if (a + 1 < g.length && !visit[a + 1][b] && g[a + 1][b] == 0) {
                answer++;
                visit[a + 1][b] = true;
                queue.add(new int[]{a + 1, b});
            }
            // 좌
            if (b - 1 >= 0 && !visit[a][b - 1] && g[a][b - 1] == 0) {
                answer++;
                visit[a][b - 1] = true;
                queue.add(new int[]{a, b - 1});
            }
            // 우
            if (b + 1 < g[a].length && !visit[a][b + 1] && g[a][b + 1] == 0) {
                answer++;
                visit[a][b + 1] = true;
                queue.add(new int[]{a, b + 1});
            }
        }
        return answer;
    }
}
