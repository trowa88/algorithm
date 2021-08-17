package baekjoon.recursion._11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder builder = new StringBuilder();
        builder.append((int) Math.pow(2, n) - 1).append("\n");
        hanoi(n, 1, 3, 2, builder);
        System.out.println(builder);
    }

    // 작은원반 n - 1개를 두번째 기둥으로 이동(세번째 기둥을 보조로)
    // 큰 원반 1개를 첫번째 세번째 기둥으로 이동
    // 작은원반 n- 1개를 두번째 기둥에서 세번쨰 기둥으로 이동(첫번째 기둥을 보조로)
    private static void hanoi(int n, int from, int to, int mid, StringBuilder builder) {
        if (n == 1) {
            builder.append(String.format("%s %s%n", from, to));
            return;
        }
        hanoi(n - 1, from, mid, to, builder);
        builder.append(String.format("%s %s%n", from, to));
        hanoi(n - 1, mid, to, from, builder);
    }
}
