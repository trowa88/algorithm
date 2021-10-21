package baekjoon.dp._1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        System.out.println(triangle(arr));
    }

    private static int triangle(int[][] arr) {
        int[][] dp = new int[arr.length][arr.length];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = arr[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        int answer = 0;
        for (int[] ints : dp) {
            for (int anInt : ints) {
                answer = Math.max(answer, anInt);
            }
        }
        return answer;
    }
}
