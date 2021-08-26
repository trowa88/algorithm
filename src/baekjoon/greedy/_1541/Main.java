package baekjoon.greedy._1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(minimum(s));
    }

    private static int minimum(String s) {
        int sum = Integer.MAX_VALUE;
        String[] minus = s.split("-");
        for (String item : minus) {
            int a = 0;
            String[] plus = item.split("\\+");
            for (String value : plus) {
                a += Integer.parseInt(value);
            }
            if (sum == Integer.MAX_VALUE) {
                sum = a;
            } else {
                sum -= a;
            }
        }
        return sum;
    }
}
