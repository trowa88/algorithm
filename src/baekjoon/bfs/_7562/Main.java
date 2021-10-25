package baekjoon.bfs._7562;

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
            int size = Integer.parseInt(br.readLine());
            int[][] chess = new int[size][size];
            int[] current = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] target = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(knight(chess, current, target));
        }
    }

    private static int knight(int[][] chess, int[] current, int[] target) {
        int x = current[0];
        int y = current[1];
        boolean[][] visit = new boolean[chess.length][chess.length];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        visit[x][y] = true;
        queue.add(new int[]{x, y, count});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            x = poll[0];
            y = poll[1];
            count = poll[2];
            if (x == target[0] && y == target[1]) {
                break;
            }
            if (x - 2 >= 0 && y - 1 >= 0 && !visit[x - 2][y - 1]) {
                visit[x - 2][y - 1] = true;
                queue.add(new int[]{x - 2, y - 1, count + 1});
            }
            if (x - 1 >= 0 && y - 2 >= 0 && !visit[x - 1][y - 2]) {
                visit[x - 1][y - 2] = true;
                queue.add(new int[]{x - 1, y - 2, count + 1});
            }
            if (x + 1 < chess.length && y - 2 >= 0 && !visit[x + 1][y - 2]) {
                visit[x + 1][y - 2] = true;
                queue.add(new int[]{x + 1, y - 2, count + 1});
            }
            if (x + 2 < chess.length && y - 1 >= 0 && !visit[x + 2][y - 1]) {
                visit[x + 2][y - 1] = true;
                queue.add(new int[]{x + 2, y - 1, count + 1});
            }
            if (x - 2 >= 0 && y + 1 < chess[x].length && !visit[x - 2][y + 1]) {
                visit[x - 2][y + 1] = true;
                queue.add(new int[]{x - 2, y + 1, count + 1});
            }
            if (x - 1 >= 0 && y + 2 < chess[x].length && !visit[x - 1][y + 2]) {
                visit[x - 1][y + 2] = true;
                queue.add(new int[]{x - 1, y + 2, count + 1});
            }
            if (x + 1 < chess.length && y + 2 < chess[x].length && !visit[x + 1][y + 2]) {
                visit[x + 1][y + 2] = true;
                queue.add(new int[]{x + 1, y + 2, count + 1});
            }
            if (x + 2 < chess.length && y + 1 < chess[x].length && !visit[x + 2][y + 1]) {
                visit[x + 2][y + 1] = true;
                queue.add(new int[]{x + 2, y + 1, count + 1});
            }
        }
        return count;
    }
}
