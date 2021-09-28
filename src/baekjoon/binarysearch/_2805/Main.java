package baekjoon.binarysearch._2805;

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
        int[] tree = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(cut(arr, tree));
    }

    private static long cut(int[] arr, int[] tree) {
        int target = arr[1];
        long max = 0;
        for (int i : tree) {
            max = Math.max(max, i);
        }
        long start = 0;
        long end = max;
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int i : tree) {
                if (i > mid) {
                    sum += i - mid;
                }
            }
            if (sum >= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}
