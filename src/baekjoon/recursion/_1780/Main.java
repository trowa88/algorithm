package baekjoon.recursion._1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Integer MINUS = 0;
    private static Integer ZERO = 0;
    private static Integer ONE = 0;
    private static int[][] ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        ARR = new int[count][count];
        for (int i = 0; i < count; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                ARR[i][j] = Integer.parseInt(s[j]);
            }
        }
        counting(0, 0, count);
        System.out.println(MINUS);
        System.out.println(ZERO);
        System.out.println(ONE);
    }

    private static boolean valid(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (ARR[i][j] != ARR[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void counting(int x, int y, int n) {
        if (valid(x, y, n)) {
            if (ARR[x][y] == -1) {
                MINUS++;
            } else if (ARR[x][y] == 0) {
                ZERO++;
            } else {
                ONE++;
            }
            return;
        }
        int num = n / 3;

        counting(x, y, num);
        counting(x, y + num, num);
        counting(x, y + 2 * num, num);

        counting(x + num, y, num);
        counting(x + num, y + num, num);
        counting(x + num, y + 2 * num, num);

        counting(x + 2 * num, y, num);
        counting(x + 2 * num, y + num, num);
        counting(x + 2 * num, y + 2 * num, num);
    }
}
