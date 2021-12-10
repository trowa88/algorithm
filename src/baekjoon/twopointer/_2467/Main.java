package baekjoon.twopointer._2467;

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
        System.out.println(solution(arr));

    }

    private static String solution(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int sum = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        while (l < r) {
            int tmp = arr[l] + arr[r];
            if (tmp == 0) {
                a = arr[l];
                b = arr[r];
                break;
            }
            if (Math.abs(sum) > Math.abs(tmp)) {
                sum = Math.abs(tmp);
                a = arr[l];
                b = arr[r];
            }
            if (tmp < 0) {
                l++;
            } else {
                r--;
            }
        }
        return String.format("%d %d", a, b);
    }
}
