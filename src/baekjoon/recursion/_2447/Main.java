package baekjoon.recursion._2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = " ";
            }
        }
        printStar(arr, 0, 0, n);
        StringBuilder builder = new StringBuilder();
        for (String[] strings : arr) {
            for (String string : strings) {
                builder.append(Objects.requireNonNullElse(string, ""));
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }

    private static void printStar(String[][] arr, int x, int y, int n) {
        if (n == 1) {
            arr[x][y] = "*";
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 1 || j != 1) {
                    printStar(arr, x + i * (n / 3), y + j * (n / 3), n/3);
                }
            }
        }
    }
}
