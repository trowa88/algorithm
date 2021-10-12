package baekjoon.bfs._11724;

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
        int[][] g = new int[arr[0] + 1][arr[0] + 1];
        boolean[] visit = new boolean[arr[0] + 1];
        for (int i = 0; i < arr[1]; i++) {
            int[] a = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int x = a[0];
            int y = a[1];
            g[x][y] = 1;
            g[y][x] = 1;
        }
        int answer = 0;
        for (int i = 1; i <= arr[0]; i++) {
            if (!visit[i]) {
                answer++;
                count(g, visit, i);
            }
        }
        System.out.println(answer);
    }

    private static void count(int[][] g, boolean[] visit, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 1; i < g[poll].length; i++) {
                if (!visit[i] && g[poll][i] == 1) {
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
