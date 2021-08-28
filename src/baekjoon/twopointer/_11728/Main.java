package baekjoon.twopointer._11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] b = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int x = 0;
        int y = 0;
        StringBuilder builder = new StringBuilder();
        while (x < a.length && y < b.length) {
            if (a[x] >= b[y]) {
                builder.append(b[y]).append(" ");
                y++;
            } else {
                builder.append(a[x]).append(" ");
                x++;
            }
        }
        while (x != a.length) {
            builder.append(a[x]).append(" ");
            x++;
        }
        while (y != b.length) {
            builder.append(b[y]).append(" ");
            y++;
        }
        System.out.println(builder);
    }
}
