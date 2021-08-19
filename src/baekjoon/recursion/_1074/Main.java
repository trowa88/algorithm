package baekjoon.recursion._1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int order = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        z((int) Math.pow(2, arr[0]), arr[1], arr[2], 0, 0);
    }

    private static void z(int size, int x, int y, int a, int b) {
        if (x == a && y == b) {
            System.out.println(order);
            return;
        }
        if (x >= a && x < a + size && y >= b && y < b + size) {
            int n = size / 2;
            // 왼쪽위
            z(n, x, y, a, b);
            // 오른쪽위
            z(n, x, y, a, b + n);
            // 왼쪽아래
            z(n, x, y, a + n, b);
            // 오른쪽아래
            z(n, x, y, a + n, b + n);
        } else {
            order += size * size;
        }
    }
}
