package baekjoon.greedy._1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }
        Arrays.sort(
                arr,
                Comparator.comparingInt((int[] value) -> value[1])
                        .thenComparingInt((int[] value) -> value[0])
        );
        System.out.println(count(arr));
    }

    private static int count(int[][] arr) {
        int n = 0;
        int end = 0;
        for (int[] a : arr) {
            if (a[0] >= end) {
                end = a[1];
                n++;
            }
        }
        return n;
    }
}
