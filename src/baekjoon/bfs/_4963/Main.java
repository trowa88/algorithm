package baekjoon.bfs._4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s.equals("0 0")) {
                break;
            }
            int[] arr = Arrays.stream(s.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[][] g = new int[arr[1]][arr[0]];
            for (int i = 0; i < arr[1]; i++) {
                String[] s1 = br.readLine().split(" ");
                for (int j = 0; j < s1.length; j++) {
                    g[i][j] = Integer.parseInt(s1[j]);
                }
            }
            System.out.println(countingIsland(g));
        }
    }

    private static int countingIsland(int[][] g) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[g.length][g[0].length];
        int answer = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (!visit[i][j] && g[i][j] == 1) {
                    answer++;
                    visit[i][j] = true;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        // 왼쪽위
                        if (x - 1 >= 0 && y - 1 >= 0 && !visit[x - 1][y - 1] && g[x - 1][y - 1] == 1) {
                            visit[x - 1][y - 1] = true;
                            queue.add(new int[]{x - 1, y - 1});
                        }
                        // 위
                        if (x - 1 >= 0 && !visit[x - 1][y] && g[x - 1][y] == 1) {
                            visit[x - 1][y] = true;
                            queue.add(new int[]{x - 1, y});
                        }
                        // 오른쪽위
                        if (x - 1 >= 0 && y + 1 < g[x].length && !visit[x - 1][y + 1] && g[x - 1][y + 1] == 1) {
                            visit[x - 1][y + 1] = true;
                            queue.add(new int[]{x - 1, y + 1});
                        }
                        // 왼쪽
                        if (y - 1 >= 0 && !visit[x][y - 1] && g[x][y - 1] == 1) {
                            visit[x][y - 1] = true;
                            queue.add(new int[]{x, y - 1});
                        }
                        // 오른쪽
                        if (y + 1 < g[x].length && !visit[x][y + 1] && g[x][y + 1] == 1) {
                            visit[x][y + 1] = true;
                            queue.add(new int[]{x, y + 1});
                        }
                        // 왼쪽아래
                        if (x + 1 < g.length && y - 1 >= 0 && !visit[x + 1][y - 1] && g[x + 1][y - 1] == 1) {
                            visit[x + 1][y - 1] = true;
                            queue.add(new int[]{x + 1, y - 1});
                        }
                        // 아래
                        if (x + 1 < g.length && !visit[x + 1][y] && g[x + 1][y] == 1) {
                            visit[x + 1][y] = true;
                            queue.add(new int[]{x + 1, y});
                        }
                        // 오른쪽아래
                        if (x + 1 < g.length && y + 1 < g[x].length && !visit[x + 1][y + 1] && g[x + 1][y + 1] == 1) {
                            visit[x + 1][y + 1] = true;
                            queue.add(new int[]{x + 1, y + 1});
                        }
                    }
                }
            }
        }
        return answer;
    }
}
