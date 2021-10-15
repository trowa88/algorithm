package baekjoon.bfs._10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] g = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            System.arraycopy(chars, 0, g[i], 0, chars.length);
        }
        System.out.println(color(g));
    }

    private static String color(char[][] g) {
        int[] answer = new int[2];
        boolean[][] visit = new boolean[g.length][g.length];
        Queue<int[]> queue = new LinkedList<>();
        // 색약 X
        int aa = 0;
        int bb = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (!visit[i][j]) {
                    aa++;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        char c = g[x][y];
                        // 상
                        if (x - 1 >= 0 && !visit[x - 1][y] && g[x - 1][y] == c) {
                            visit[x - 1][y] = true;
                            queue.add(new int[]{x - 1, y});
                        }
                        // 하
                        if (x + 1 < g.length && !visit[x + 1][y] && g[x + 1][y] == c) {
                            visit[x + 1][y] = true;
                            queue.add(new int[]{x + 1, y});
                        }
                        // 좌
                        if (y - 1 >= 0 && !visit[x][y - 1] && g[x][y - 1] == c) {
                            visit[x][y - 1] = true;
                            queue.add(new int[]{x, y - 1});
                        }
                        // 우
                        if (y + 1 < g[x].length && !visit[x][y + 1] && g[x][y + 1] == c) {
                            visit[x][y + 1] = true;
                            queue.add(new int[]{x, y + 1});
                        }
                    }
                }
            }
        }
        answer[0] = aa;
        // 색약 O
        visit = new boolean[g.length][g.length];
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (!visit[i][j]) {
                    bb++;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        char c = g[x][y];
                        if (c == 'R' || c == 'G') {
                            // 상
                            if (x - 1 >= 0 && !visit[x - 1][y] && (g[x - 1][y] == 'R' || g[x - 1][y] == 'G')) {
                                visit[x - 1][y] = true;
                                queue.add(new int[]{x - 1, y});
                            }
                            // 하
                            if (x + 1 < g.length && !visit[x + 1][y] && (g[x + 1][y] == 'R' || g[x + 1][y] == 'G')) {
                                visit[x + 1][y] = true;
                                queue.add(new int[]{x + 1, y});
                            }
                            // 좌
                            if (y - 1 >= 0 && !visit[x][y - 1] && (g[x][y - 1] == 'R' || g[x][y - 1] == 'G')) {
                                visit[x][y - 1] = true;
                                queue.add(new int[]{x, y - 1});
                            }
                            // 우
                            if (y + 1 < g[x].length && !visit[x][y + 1] && (g[x][y + 1] == 'R' || g[x][y + 1] == 'G')) {
                                visit[x][y + 1] = true;
                                queue.add(new int[]{x, y + 1});
                            }
                        } else {
                            // 상
                            if (x - 1 >= 0 && !visit[x - 1][y] && g[x - 1][y] == c) {
                                visit[x - 1][y] = true;
                                queue.add(new int[]{x - 1, y});
                            }
                            // 하
                            if (x + 1 < g.length && !visit[x + 1][y] && g[x + 1][y] == c) {
                                visit[x + 1][y] = true;
                                queue.add(new int[]{x + 1, y});
                            }
                            // 좌
                            if (y - 1 >= 0 && !visit[x][y - 1] && g[x][y - 1] == c) {
                                visit[x][y - 1] = true;
                                queue.add(new int[]{x, y - 1});
                            }
                            // 우
                            if (y + 1 < g[x].length && !visit[x][y + 1] && g[x][y + 1] == c) {
                                visit[x][y + 1] = true;
                                queue.add(new int[]{x, y + 1});
                            }
                        }
                    }
                }
            }
        }
        answer[1] = bb;
        return String.join(" ", String.valueOf(answer[0]), String.valueOf(answer[1]));
    }
}
