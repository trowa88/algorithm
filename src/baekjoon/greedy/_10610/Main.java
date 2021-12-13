package baekjoon.greedy._10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(thirty(s));
    }

    private static String thirty(String s) {
        if (!s.contains("0")) {
            return "-1";
        }
        long[] arr = Arrays.stream(s.split(""))
                .mapToLong(Long::parseLong)
                .toArray();
        int tmp = 0;
        for (long i : arr) {
            tmp += i;
        }
        if (tmp % 3 != 0) {
            return "-1";
        }
        Arrays.sort(arr);
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            builder.append(arr[i]);
        }
        return builder.toString();
    }
}
