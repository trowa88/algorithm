package baekjoon.greedy._2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(rope(arr));
    }

    private static int rope(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            answer = Math.max(answer, arr[i] * (arr.length - i));
        }
        return answer;
    }
}
