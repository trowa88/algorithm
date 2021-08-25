package baekjoon.bfs._1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int start = Integer.parseInt(s[2]);
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        boolean[] visitDfs = new boolean[n + 1];
        boolean[] visitBfs = new boolean[n + 1];
        StringBuilder d = new StringBuilder();
        StringBuilder b = new StringBuilder();
        dfs(arr, start, visitDfs, d);
        bfs(arr, start, visitBfs, b);
        System.out.println(d.toString().trim());
        System.out.println(b.toString().trim());
    }

    private static void dfs(int[][] arr, int start, boolean[] visit, StringBuilder d) {
        d.append(start).append(" ");
        visit[start] = true;
        for (int i = 0; i < arr[start].length; i++) {
            if (arr[start][i] == 1 && !visit[i]) {
                dfs(arr, i, visit, d);
            }
        }
    }

    private static void bfs(int[][] arr, int start, boolean[] visit, StringBuilder b) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        b.append(start).append(" ");
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 0; i < arr[poll].length; i++) {
                if (arr[poll][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                    b.append(i).append(" ");
                }
            }
        }
    }
}
