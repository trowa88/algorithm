package baekjoon.twopointer._2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        twoSolution(arr);
    }

    private static void twoSolution(int[] arr) {
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;
        int answer = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        while (l < r) {
            if (Math.abs(arr[l] + arr[r]) < answer) {
                a = l;
                b = r;
                answer = Math.abs(arr[l] + arr[r]);
            }
            if (arr[l] + arr[r] < 0) {
                l++;
            } else {
                r--;
            }
        }
        System.out.printf("%s %s", arr[a], arr[b]);
    }
}
