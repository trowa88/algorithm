package baekjoon.string._2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        System.out.println(sangsu(s));
    }

    private static int sangsu(String[] s) {
        int max = 0;
        for (String value : s) {
            StringBuilder builder = new StringBuilder();
            for (int j = value.length() - 1; j >= 0; j--) {
                builder.append(value.charAt(j));
            }
            max = Math.max(max, Integer.parseInt(builder.toString()));
        }
        return max;
    }
}
