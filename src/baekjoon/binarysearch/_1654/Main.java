package baekjoon.binarysearch._1654;

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
        int[] lines = new int[arr[0]];
        for (int i = 0; i < arr[0]; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(cut(arr, lines));
    }

    private static long cut(int[] arr, int[] lines) {
        int target = arr[1];
        long max = 0;
        for (int line : lines) {
            max = Math.max(max, line);
        }
        long start = 1;
        long end = max;
        while (start <= end) {
            long mid = (start + end) / 2;
            int count = 0;
            for (int line : lines) {
                count += line / mid;
            }
            if (count >= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}
