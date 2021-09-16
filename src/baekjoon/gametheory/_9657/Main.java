package baekjoon.gametheory._9657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(stone(n));
    }

    private static String stone(int n) {
        // n == 1 SK
        // n == 2 CY
        // n == 3 SK
        // n == 4 SK
        // n == 5 CY
        // n == 6 SK
        return (n % 7 == 0 || n % 7 == 2)
                ? "CY"
                : "SK";
    }
}
