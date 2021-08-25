package baekjoon.dfs._2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i < d; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        boolean[] visit = new boolean[n + 1];
        dfs(arr, 1, visit);
        System.out.println(count - 1);
    }

    private static void dfs(int[][] arr, int start, boolean[] visit) {
        visit[start] = true;
        count++;
        for (int i = 0; i < arr[start].length; i++) {
            if (!visit[i] && arr[start][i] == 1) {
                dfs(arr, i, visit);
            }
        }
    }
}
