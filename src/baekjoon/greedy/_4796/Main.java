package baekjoon.greedy._4796;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 1;
        while (true) {
            String s = br.readLine();
            if (s.equals("0 0 0")) {
                break;
            }
            int[] arr = Arrays.stream(s.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(camping(index++, arr));
        }
    }

    private static String camping(int index, int[] arr) {
        int L = arr[0];
        int P = arr[1];
        int V = arr[2];
        int count = (V / P) * L + (Math.min(V % P, L));
        return String.format("Case %s: %s", index, count);
    }
}
