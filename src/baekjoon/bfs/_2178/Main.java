package baekjoon.bfs._2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        int[][] arr = new int[x][y];
        int[][] d = new int[x][y];
        boolean[][] visit = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            String s1 = br.readLine();
            for (int i1 = 0; i1 < s1.length(); i1++) {
                arr[i][i1] = Integer.parseInt(String.valueOf(s1.charAt(i1)));
            }
        }
        bfs(arr, visit, d);
        System.out.println(d[x - 1][y - 1]);
    }

    private static void bfs(int[][] arr, boolean[][] visit, int[][] d) {
        int x = 0;
        int y = 0;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(x, y));
        d[0][0] = 1;
        while (!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            int a = poll.get(0);
            int b = poll.get(1);
            // 상
            if (a - 1 >= 0 && !visit[a - 1][b] && arr[a - 1][b] == 1) {
                d[a - 1][b] = d[a][b] + 1;
                visit[a - 1][b] = true;
                queue.add(List.of(a - 1, b));
            }
            // 하
            if (a + 1 < arr.length && !visit[a + 1][b] && arr[a + 1][b] == 1) {
                d[a + 1][b] = d[a][b] + 1;
                visit[a + 1][b] = true;
                queue.add(List.of(a + 1, b));
            }
            // 좌
            if (b - 1 >= 0 && !visit[a][b - 1] && arr[a][b - 1] == 1) {
                d[a][b - 1] = d[a][b] + 1;
                visit[a][b - 1] = true;
                queue.add(List.of(a, b - 1));
            }
            // 우
            if (b + 1 < arr[a].length && !visit[a][b + 1] && arr[a][b + 1] == 1) {
                d[a][b + 1] = d[a][b] + 1;
                visit[a][b + 1] = true;
                queue.add(List.of(a, b + 1));
            }
        }
    }
}
