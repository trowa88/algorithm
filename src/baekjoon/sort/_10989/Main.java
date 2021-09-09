package baekjoon.sort._10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10_000_001];
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())] += 1;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                for (int j = 0; j < arr[i]; j++) {
                    builder.append(i).append("\n");
                }
            }
        }
        System.out.println(builder);
    }
}
