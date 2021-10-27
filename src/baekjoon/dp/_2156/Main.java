package baekjoon.dp._2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(wine(arr));
    }

    private static int wine(int[] arr) {
        int[] dp = new int[arr.length];
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return arr[0] + arr[1];
        }
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
        for (int i = 3; i < arr.length; i++) {
            // XOO => dp[i-3] + arr[i - 1] + arr[i]
            // OXO => dp[i-2] + arr[i]
            // OOX => dp[i -1]
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }
        return Arrays.stream(dp)
                .max()
                .orElseThrow();
    }
}
