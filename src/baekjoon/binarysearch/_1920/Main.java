package baekjoon.binarysearch._1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        br.readLine();
        String[] s1 = br.readLine().split(" ");
        Arrays.sort(arr);
        for (String value : s1) {
            System.out.println(search(arr, Integer.parseInt(value)));
        }
    }

    private static int search(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target < arr[m]) {
                r = m - 1;
            } else if (target > arr[m]) {
                l = m + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
