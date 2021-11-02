package baekjoon.sort._2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 9;
        int[] arr = new int[9];
        int total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }
        Arrays.sort(arr);
        int[] not = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (total - arr[i] - arr[j] == 100) {
                    not[0] = i;
                    not[1] = j;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != not[0] && i != not[1]) {
                System.out.println(arr[i]);
            }
        }
    }
}
