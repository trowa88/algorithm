package baekjoon.string._5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(dial(s));
    }

    private static int dial(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 87) {
                sum += 10;
            } else if (c >= 84) {
                sum += 9;
            } else if (c >= 80) {
                sum += 8;
            } else if (c >= 77) {
                sum += 7;
            } else if (c >= 74) {
                sum += 6;
            } else if (c >= 71) {
                sum += 5;
            } else if (c >= 68) {
                sum += 4;
            } else if (c >= 65) {
                sum += 3;
            }
        }
        return sum;
    }
}
