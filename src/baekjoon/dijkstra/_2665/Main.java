package baekjoon.dijkstra._2665;

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
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                g[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        System.out.println(makeMiro(g));
    }

    private static int makeMiro(int[][] g) {
        int[][] d = new int[g.length][g.length];
        for (int[] ints : d) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        d[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= g.length || ny < 0 || ny >= g.length) {
                    continue;
                }
                if (d[x][y] >= d[nx][ny]) {
                    continue;
                }
                queue.add(new int[]{nx, ny});
                if (g[nx][ny] == 1) {
                    d[nx][ny] = d[x][y];
                } else {
                    d[nx][ny] = d[x][y] + 1;
                }
            }
        }
        return d[g.length - 1][g.length - 1];
    }
}
