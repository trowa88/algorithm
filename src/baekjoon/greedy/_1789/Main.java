package baekjoon.greedy._1789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(sum(Long.parseLong(br.readLine())));
    }

    private static long sum(long n) {
        long i = 1;
        long sum;
        while (true) {
            sum = i * (i + 1) / 2;
            if (sum >= n) {
                break;
            }
            i++;
        }
        return sum > n ? i - 1 : i;
    }
}
