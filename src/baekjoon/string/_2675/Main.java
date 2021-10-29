package baekjoon.string._2675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println(
                    repeatString(br.readLine().split(" "))
            );
        }
    }

    private static String repeatString(String[] s) {
        int n = Integer.parseInt(s[0]);
        String str = s[1];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            builder.append(String.valueOf(str.charAt(i)).repeat(n));
        }
        return builder.toString();
    }
}
