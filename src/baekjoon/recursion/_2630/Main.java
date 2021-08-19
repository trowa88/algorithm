package baekjoon.recursion._2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int BLUE = 0;
    private static int WHITE = 0;

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
        colorPaper(arr, 0, 0, n);
        System.out.println(WHITE);
        System.out.println(BLUE);
    }

    private static void colorPaper(int[][] arr, int a, int b, int size) {
        if (check(arr, a, b, size)) {
            if (arr[a][b] == 0) {
                WHITE++;
            } else {
                BLUE++;
            }
            return;
        }
        int n = size / 2;
        // 왼쪽위
        colorPaper(arr, a, b, n);
        // 오른쪽위
        colorPaper(arr, a, b + n, n);
        // 왼쪽아래
        colorPaper(arr, a + n, b, n);
        // 오른쪽아래
        colorPaper(arr, a + n, b + n, n);
    }

    private static boolean check(int[][] arr, int a, int b, int size) {
        for (int i = a; i < a + size; i++) {
            for (int j = b; j < b + size; j++) {
                if (arr[i][j] != arr[a][b]) {
                    return false;
                }
            }
        }
        return true;
    }
}
