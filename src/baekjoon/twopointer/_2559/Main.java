package baekjoon.twopointer._2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int day = arr[1];
        int[] t = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int answer = 0;
        int tmp = 0;
        int l = 0;
        int r = day - 1;
        for (int i = 0; i < day; i++) {
            answer += t[i];
            tmp = answer;
        }
        while (r != t.length - 1) {
            tmp += t[++r];
            tmp -= t[l++];
            answer = Math.max(answer, tmp);
        }
        System.out.println(answer);
    }
}
