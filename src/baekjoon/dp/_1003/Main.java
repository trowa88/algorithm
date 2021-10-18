package baekjoon.dp._1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] zeroDp = new int[41];
        int[] oneDp = new int[41];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(
                    zeroFibonacci(num, zeroDp)
                            + " "
                            + oneFibonacci(num, oneDp)
            );
        }
    }

    private static int zeroFibonacci(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = zeroFibonacci(n - 1, dp) + zeroFibonacci(n - 2, dp);
        return dp[n];
    }

    private static int oneFibonacci(int n, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = oneFibonacci(n - 1, dp) + oneFibonacci(n - 2, dp);
        return dp[n];
    }
}
