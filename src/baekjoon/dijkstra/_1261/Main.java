package baekjoon.dijkstra._1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] g = new int[arr[1]][arr[0]];
        for (int i = 0; i < g.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                g[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        System.out.println(algoSpot(g));
    }

    private static int algoSpot(int[][] g) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(value -> value[2]));
        queue.add(new int[]{0, 0, 0});
        int[][] d = new int[g.length][g[0].length];
        boolean[][] visit = new boolean[g.length][g[0].length];
        visit[0][0] = true;
        for (int[] ints : d) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        d[0][0] = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int wall = poll[2];
            d[x][y] = Math.min(d[x][y], wall);
            if (x == g.length - 1 && y == g[x].length - 1) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= g.length || ny < 0 || ny >= g[x].length) {
                    continue;
                }
                if (visit[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;
                if (g[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny, wall + 1});
                } else {
                    queue.add(new int[]{nx, ny, wall});
                }
            }
        }
        return d[g.length - 1][g[0].length - 1];
    }
}
