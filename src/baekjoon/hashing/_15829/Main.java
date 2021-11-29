package baekjoon.hashing._15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        System.out.println(hash(br.readLine()));
    }

    public static long hash(String s) {
        long sum = 0;
        long m = 1234567891;
        long r = 1;
        for (int i = 0; i < s.length(); i++) {
            sum += (s.charAt(i) - 'a' + 1) * r;
            r = (r * 31) % m;
        }
        return sum % m;
    }
}
