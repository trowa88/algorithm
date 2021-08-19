package baekjoon.recursion._2448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        arr = new char[count][count * 2];
        for (char[] chars : arr) {
            Arrays.fill(chars, ' ');
        }
        star(count, 0, count - 1);
        StringBuilder builder = new StringBuilder();
        for (char[] chars : arr) {
            for (char c : chars) {
                builder.append(c == '*' ? '*' : " ");
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }

    private static void star(int h, int x, int y) {
        if (h == 3) {
            arr[x][y] = '*';
            arr[x + 1][y - 1] = '*';
            arr[x + 1][y + 1] = '*';
            arr[x + 2][y - 2] = '*';
            arr[x + 2][y - 1] = '*';
            arr[x + 2][y] = '*';
            arr[x + 2][y + 1] = '*';
            arr[x + 2][y + 2] = '*';
            return;
        }
        int height = h / 2;
        star(height, x, y);
        star(height, x + height, y - height);
        star(height, x + height, y + height);
    }
}
