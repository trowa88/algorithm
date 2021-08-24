package baekjoon.greedy._11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int total = Integer.parseInt(s[1]);
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(countCoin(coin, total));
    }

    private static int countCoin(int[] coin, int total) {
        int n = 0;
        int i = coin.length - 1;
        while (total != 0) {
            if (total >= coin[i]) {
                n += total / coin[i];
                total %= coin[i];
            } else {
                i--;
            }
        }
        return n;
    }
}
