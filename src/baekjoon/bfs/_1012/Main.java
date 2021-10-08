package baekjoon.bfs._1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[][] g = new int[arr[1]][arr[0]];
            boolean[][] v = new boolean[arr[1]][arr[0]];
            for (int j = 0; j < arr[2]; j++) {
                int[] s = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                g[s[1]][s[0]] = 1;
            }
            int result = 0;
            for (int a = 0; a < g.length; a++) {
                for (int b = 0; b < g[a].length; b++) {
                    if (!v[a][b] && g[a][b] == 1) {
                        result++;
                        bfs(g, v, a, b);
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static void bfs(int[][] g, boolean[][] v, int x, int y) {
        if (v[x][y]) {
            return;
        }
        v[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int a = poll[0];
            int b = poll[1];
            if (b - 1 >= 0 && !v[a][b - 1] && g[a][b - 1] == 1) {
                v[a][b - 1] = true;
                queue.add(new int[]{a, b - 1});
            }
            // 하
            if (a + 1 < g.length && !v[a + 1][b] && g[a + 1][b] == 1) {
                v[a + 1][b] = true;
                queue.add(new int[]{a + 1, b});
            }
            // 좌
            if (a - 1 >= 0 && !v[a - 1][b] && g[a - 1][b] == 1) {
                v[a - 1][b] = true;
                queue.add(new int[]{a - 1, b});
            }
            // 우
            if (b + 1 < g[a].length && !v[a][b + 1] && g[a][b + 1] == 1) {
                v[a][b + 1] = true;
                queue.add(new int[]{a, b + 1});
            }
        }
    }
}
