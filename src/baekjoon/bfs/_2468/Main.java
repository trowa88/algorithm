package baekjoon.bfs._2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] g = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                int rain = Integer.parseInt(s[j]);
                max = Integer.max(max, rain);
                g[i][j] = rain;

            }
        }
        int answer = 0;
        for (int i = 0; i <= max; i++) {
            answer = Math.max(answer, safeArea(g, i));
        }
        System.out.println(answer);
    }

    private static int safeArea(int[][] g, int rain) {
        int answer = 0;
        boolean[][] visit = new boolean[g.length][g.length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g.length; j++) {
                if (!visit[i][j] && g[i][j] > rain) {
                    visit[i][j] = true;
                    queue.add(new int[]{i, j});
                    answer++;
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        // 상
                        if (x - 1 >= 0 && !visit[x - 1][y] && g[x - 1][y] > rain) {
                            visit[x - 1][y] = true;
                            queue.add(new int[]{x - 1, y});
                        }
                        // 하
                        if (x + 1 < g.length && !visit[x + 1][y] && g[x + 1][y] > rain) {
                            visit[x + 1][y] = true;
                            queue.add(new int[]{x + 1, y});
                        }
                        // 좌
                        if (y - 1 >= 0 && !visit[x][y - 1] && g[x][y - 1] > rain) {
                            visit[x][y - 1] = true;
                            queue.add(new int[]{x, y - 1});
                        }
                        // 우
                        if (y + 1 < g.length && !visit[x][y + 1] && g[x][y + 1] > rain) {
                            visit[x][y + 1] = true;
                            queue.add(new int[]{x, y + 1});
                        }
                    }
                }
            }
        }
        return answer;
    }
}
