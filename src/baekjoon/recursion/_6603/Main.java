package baekjoon.recursion._6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) {
                break;
            }
            String[] s1 = s.split(" ");
            int num = Integer.parseInt(s1[0]);
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = Integer.parseInt(s1[i + 1]);
            }
            StringBuilder builder = new StringBuilder();
            lotto(arr, 0, 0, builder);
            System.out.println();
        }
    }

    private static void lotto(int[] arr, int n, int start, StringBuilder builder) {
        if (start == arr.length) {
            if (n == 6) {
                System.out.println(builder.toString().trim());
            }
            return;
        }
        lotto(arr, n + 1, start + 1, new StringBuilder(builder).append(arr[start]).append(" "));
        lotto(arr, n, start + 1, new StringBuilder(builder));
    }
}
// 1 1 0 0 0 0 1 0 1 1 0 1 1 0 0 1 1 0 1
