package baekjoon.sort._11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(String.valueOf(s[i]));
        }
        Arrays.sort(arr);
        int answer = 0;
        int total = 0;
        for (int j : arr) {
            answer += j;
            total += answer;
        }
        System.out.println(total);
    }
}
//