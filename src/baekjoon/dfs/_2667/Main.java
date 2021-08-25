package baekjoon.dfs._2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        boolean[][] visit = new boolean[n][n];
        int[][] mark = new int[n][n];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!visit[i][j] && arr[i][j] == 1) {
                    count++;
                    dfs(arr, i, j, visit, mark, count);
                }
            }
        }
        System.out.println(count);
        int[] result = new int[count];
        for (int[] m : mark) {
            for (int i : m) {
                if (i == 0) {
                    continue;
                }
                result[i - 1] += 1;
            }
        }
        Arrays.sort(result);
        for (int j : result) {
            System.out.println(j);
        }
    }

    private static void dfs(int[][] arr, int a, int b, boolean[][] visit, int[][] mark, int n) {
        visit[a][b] = true;
        mark[a][b] = n;
        // 상
        if (a - 1 >= 0 && !visit[a - 1][b] && arr[a - 1][b] == 1) {
            dfs(arr, a - 1, b, visit, mark, n);
        }
        // 하
        if (a + 1 < arr.length && !visit[a + 1][b] && arr[a + 1][b] == 1) {
            dfs(arr, a + 1, b, visit, mark, n);
        }
        // 좌
        if (b - 1 >= 0 && !visit[a][b - 1] && arr[a][b - 1] == 1) {
            dfs(arr, a, b - 1, visit, mark, n);
        }
        // 우
        if (b + 1 < arr[a].length && !visit[a][b + 1] && arr[a][b + 1] == 1) {
            dfs(arr, a, b + 1, visit, mark, n);
        }
    }
}
