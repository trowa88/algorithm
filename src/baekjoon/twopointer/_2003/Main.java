package baekjoon.twopointer._2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int target = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        String[] ss = br.readLine().split(" ");
        for (int i = 0; i < ss.length; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }
        System.out.println(sumNumber(arr, target));
    }

    private static int sumNumber(int[] arr, int target) {
        int answer = 0;
        int a = 0;
        int b = 0;
        int tmp = 0;
        while (true) {
            if (tmp >= target) {
                tmp -= arr[a];
                a++;
            } else if (b == arr.length) {
                break;
            } else {
                tmp += arr[b];
                b++;
            }
            if (tmp == target) {
                answer++;
            }
        }
        return answer;
    }
}
