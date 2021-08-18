package baekjoon.recursion._1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[][] tree = new int[count][count];
        for (int i = 0; i < count; i++) {
            String readLine = br.readLine();
            for (int j = 0; j < readLine.length(); j++) {
                tree[i][j] = Integer.parseInt(String.valueOf(readLine.charAt(j)));
            }
        }
        StringBuilder builder = new StringBuilder();
        quadTree(tree, 0, 0, count, builder);
        System.out.println(builder);
    }

    private static void quadTree(int[][] tree, int x, int y, int n, StringBuilder builder) {
        if (n == 1) {
            builder.append(tree[x][y]);
            return;
        }
        builder.append("(");
        quadTree(tree, x, y, n / 2, builder);
        quadTree(tree, x, y + n / 2, n / 2, builder);
        quadTree(tree, x + n / 2, y, n / 2, builder);
        quadTree(tree, x + n / 2, y + n / 2, n / 2, builder);
        builder.append(")");
        checkNumber(builder);
    }

    private static void checkNumber(StringBuilder builder) {
        int zero = 0;
        int one = 0;
        for (int i = builder.length() - 2; i >= builder.length() - 5; i--) {
            if (builder.charAt(i) == '0') {
                zero++;
            } else if (builder.charAt(i) == '1') {
                one++;
            }
        }
        // ((1111)
        //  마지막 괄호부터 처음 만나는 괄호까지 replace
        if (zero == 4) {
            builder.replace(builder.length() - 6, builder.length(), "0");
        } else if (one == 4) {
            builder.replace(builder.length() - 6, builder.length(), "1");
        }
    }
}
