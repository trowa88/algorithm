package baekjoon.bfs._7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][][] g = new int[arr[2]][arr[1]][arr[0]];
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                String[] s = br.readLine().split(" ");
                for (int k = 0; k < s.length; k++) {
                    g[i][j][k] = Integer.parseInt(s[k]);
                }
            }
        }
        boolean[][][] visit = new boolean[arr[2]][arr[1]][arr[0]];
        System.out.println(tomato(g, visit));
    }

    private static int tomato(int[][][] g, boolean[][][] visit) {
        Queue<int[]> queue = new LinkedList<>();
        int days = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                for (int k = 0; k < g[i][j].length; k++) {
                    if (!visit[i][j][k] && g[i][j][k] == 1) {
                        visit[i][j][k] = true;
                        queue.add(new int[]{i, j, k, 0});
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int h = poll[0];
            int n = poll[1];
            int m = poll[2];
            days = poll[3];
            // 위
            if (n - 1 >= 0 && !visit[h][n - 1][m] && g[h][n - 1][m] == 0) {
                visit[h][n - 1][m] = true;
                g[h][n - 1][m] = 1;
                queue.add(new int[]{h, n - 1, m, days + 1});
            }
            // 아래
            if (n + 1 < g[h].length && !visit[h][n + 1][m] && g[h][n + 1][m] == 0) {
                visit[h][n + 1][m] = true;
                g[h][n + 1][m] = 1;
                queue.add(new int[]{h, n + 1, m, days + 1});
            }

            // 왼쪽
            if (m - 1 >= 0 && !visit[h][n][m - 1] && g[h][n][m - 1] == 0) {
                visit[h][n][m - 1] = true;
                g[h][n][m - 1] = 1;
                queue.add(new int[]{h, n, m - 1, days + 1});
            }
            // 오른쪽
            if (m + 1 < g[h][n].length && !visit[h][n][m + 1] && g[h][n][m + 1] == 0) {
                visit[h][n][m + 1] = true;
                g[h][n][m + 1] = 1;
                queue.add(new int[]{h, n, m + 1, days + 1});
            }
            // 앞
            if (h - 1 >= 0 && !visit[h - 1][n][m] && g[h - 1][n][m] == 0) {
                visit[h - 1][n][m] = true;
                g[h - 1][n][m] = 1;
                queue.add(new int[]{h - 1, n, m, days + 1});
            }
            // 뒤
            if (h + 1 < g.length && !visit[h + 1][n][m] && g[h + 1][n][m] == 0) {
                visit[h + 1][n][m] = true;
                g[h + 1][n][m] = 1;
                queue.add(new int[]{h + 1, n, m, days + 1});
            }
        }
        for (int[][] ints : g) {
            for (int[] anInt : ints) {
                for (int i : anInt) {
                    if (i == 0) {
                        return -1;
                    }
                }
            }
        }
        return days;
    }
}
