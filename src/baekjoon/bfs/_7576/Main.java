package baekjoon.bfs._7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] g = new int[arr[1]][arr[0]];
        for (int i = 0; i < arr[1]; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                int n = Integer.parseInt(s[j]);
                g[i][j] = n;
                if (n == 1) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }
        System.out.println(bfs(g, 0, 0));
    }

    private static int bfs(int[][] g, int x, int y) {
        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int a = poll[0];
            int b = poll[1];
            int day = poll[2];
            result = day;
            // 상
            if (b - 1 >= 0 && g[a][b - 1] == 0) {
                g[a][b - 1] = 1;
                queue.add(new int[]{a, b - 1, day + 1});
            }
            // 하
            if (a + 1 < g.length && g[a + 1][b] == 0) {
                g[a + 1][b] = 1;
                queue.add(new int[]{a + 1, b, day + 1});
            }
            // 좌
            if (a - 1 >= 0 && g[a - 1][b] == 0) {
                g[a - 1][b] = 1;
                queue.add(new int[]{a - 1, b, day + 1});
            }
            // 우
            if (b + 1 < g[a].length && g[a][b + 1] == 0) {
                g[a][b + 1] = 1;
                queue.add(new int[]{a, b + 1, day + 1});
            }
        }
        for (int[] ints : g) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    return -1;
                }
            }
        }
        return result;
    }
}
