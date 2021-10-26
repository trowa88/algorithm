package baekjoon.bfs._2206;

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
        int[][] g = new int[arr[0]][arr[1]];
        for (int i = 0; i < g.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                g[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        int answer = wall(g);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static int wall(int[][] g) {
        int answer = Integer.MAX_VALUE;
        boolean[][][] visit = new boolean[2][g.length][g[0].length];
        visit[0][0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0});
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int d = poll[2];
            int destroy = poll[3];
            if (x == g.length - 1 && y == g[0].length - 1) {
                answer = d;
                break;
            }
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= g.length || ny < 0 || ny >= g[x].length) {
                    continue;
                }
                if (g[nx][ny] == 1) {
                    if (destroy == 0 && !visit[1][nx][ny]) {
                        visit[0][nx][ny] = true;
                        queue.add(new int[]{nx, ny, d + 1, 1});
                    }
                } else {
                    if (!visit[destroy][nx][ny]) {
                        visit[destroy][nx][ny] = true;
                        queue.add(new int[]{nx, ny, d + 1, destroy});
                    }
                }
            }
        }
        return answer;
    }
}
