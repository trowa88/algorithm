package baekjoon.string._1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] arr = new int[91];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        countingWord(s);
    }

    private static void countingWord(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                arr[c - 32] += 1;
                max = Math.max(max, arr[c - 32]);
            } else {
                arr[c] += 1;
                max = Math.max(max, arr[c]);
            }
        }
        char c = '0';
        for (int i = 64; i < arr.length; i++) {
            if (arr[i] == max && c == '0') {
                c = (char) (i);
            } else if (arr[i] == max) {
                c = '?';
            }
        }
        System.out.println(c);
    }
}
