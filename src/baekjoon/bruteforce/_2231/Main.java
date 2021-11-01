package baekjoon.bruteforce._2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(decompose(n));
    }

    private static int decompose(int n) {
        for (int i = 1; i < n; i++) {
            int tmp = i;
            int sum = tmp;
            while (tmp != 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (sum == n) {
                return i;
            }
        }
        return 0;
    }
}
