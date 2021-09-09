package baekjoon.gametheory._9655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(stoneGame(n));
    }

    private static String stoneGame(int n) {
        if (n % 2 != 0) {
            return "SK";
        } else {
            return "CY";
        }
    }
}
