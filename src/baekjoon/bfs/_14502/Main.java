package baekjoon.bfs._14502;

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
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                g[i][j] = Integer.parseInt(s[j]);
            }
        }
        System.out.println(lab(g, 0));
    }

    private static int lab(int[][] g, int wall) {
        if (wall == 3) {
            return spread(copyArray(g));
        }

        int answer = 0;
        int[][] tmp = copyArray(g);
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] == 0) {
                    tmp[i][j] = 1;
                    answer = Math.max(answer, lab(tmp, wall + 1));
                    tmp[i][j] = 0;
                }
            }
        }
        return answer;
    }

    private static int spread(int[][] arr) {
        int answer = 0;
        int[][] tmp = copyArray(arr);
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[tmp.length][tmp[0].length];
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                if (!visit[i][j] && tmp[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        // 상
                        if (x - 1 >= 0 && !visit[x - 1][y] && tmp[x - 1][y] == 0) {
                            visit[x - 1][y] = true;
                            tmp[x - 1][y] = 2;
                            queue.add(new int[]{x - 1, y});
                        }
                        // 하
                        if (x + 1 < tmp.length && !visit[x + 1][y] && tmp[x + 1][y] == 0) {
                            visit[x + 1][y] = true;
                            tmp[x + 1][y] = 2;
                            queue.add(new int[]{x + 1, y});
                        }
                        // 좌
                        if (y - 1 >= 0 && !visit[x][y - 1] && tmp[x][y - 1] == 0) {
                            visit[x][y - 1] = true;
                            tmp[x][y - 1] = 2;
                            queue.add(new int[]{x, y - 1});
                        }
                        // 우
                        if (y + 1 < tmp[x].length && !visit[x][y + 1] && tmp[x][y + 1] == 0) {
                            visit[x][y + 1] = true;
                            tmp[x][y + 1] = 2;
                            queue.add(new int[]{x, y + 1});
                        }
                    }
                }
            }
        }
        for (int[] ints : tmp) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private static int[][] copyArray(int[][] g) {
        int[][] copy = new int[g.length][g[0].length];
        for (int i = 0; i < g.length; i++) {
            System.arraycopy(g[i], 0, copy[i], 0, g[i].length);
        }
        return copy;
    }
}
