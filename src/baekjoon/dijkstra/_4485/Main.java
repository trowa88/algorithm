package baekjoon.dijkstra._4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 1;
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) {
                break;
            }
            int n = Integer.parseInt(s);
            int[][] arr = new int[n][n];
            for (int[] ints : arr) {
                int[] g = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                System.arraycopy(g, 0, ints, 0, g.length);
            }
            System.out.println(zelda(arr, i++));
        }
    }

    private static String zelda(int[][] arr, int number) {
        int answer = 0;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(value -> value[2]));
        boolean[][] visit = new boolean[arr.length][arr.length];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        queue.add(new int[]{0, 0, arr[0][0]});
        visit[0][0] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int a = poll[0];
            int b = poll[1];
            int d = poll[2];
            if (a == arr.length - 1 && b == arr.length - 1) {
                answer = d;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];
                if (nx < 0
                        || nx >= arr.length
                        || ny < 0
                        || ny >= arr.length
                        || visit[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny, d + arr[nx][ny]});
            }
        }
        return String.format("Problem %s: %s", number, answer);
    }
}
