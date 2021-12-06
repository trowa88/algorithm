package baekjoon.binarysearch._1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long total = arr[0];
        long win = arr[1];
        if ((win * 100 / total) >= 99) {
            System.out.println(-1);
            return;
        }
        System.out.println(binarySearch(win, total));
    }

    private static long binarySearch(long win, long total) {
        long initial = win * 100 / total;
        long start = 1;
        long end = total;
        while (start <= end) {
            long mid = (start + end) / 2;
            long percent = (win + mid) * 100 / (total + mid);
            if (percent > initial) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
// (a + x) * 100 / b + x = c
