package baekjoon.dp._1149;

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
        System.out.println(rgb(arr));
    }

    private static int rgb(int[][] arr) {
        int answer = Integer.MAX_VALUE;
        int[][] d = new int[arr.length][arr[0].length];
        d[0][0] = arr[0][0];
        d[0][1] = arr[0][1];
        d[0][2] = arr[0][2];
        for (int i = 1; i < arr.length; i++) {
            // R
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + arr[i][0];
            // G
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + arr[i][1];
            // B
            d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + arr[i][2];
        }
        return Math.min(d[d.length - 1][0], Math.min(d[d.length - 1][1], d[d.length - 1][2]));
    }
}
