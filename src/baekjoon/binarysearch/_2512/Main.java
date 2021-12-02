package baekjoon.binarysearch._2512;

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
        int total = Integer.parseInt(br.readLine());
        System.out.println(estimate(arr, total));
    }

    private static long estimate(int[] arr, int total) {
        long answer = 0;
        Arrays.sort(arr);
        long left = 0;
        long right = arr[arr.length - 1];
        while (left <= right) {
            long mid = (left + right) / 2;
            long tmp = 0;
            for (int i : arr) {
                if (i >= mid) {
                    tmp += mid;
                } else {
                    tmp += i;
                }
            }
            if (tmp > total) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        return answer;
    }
}
