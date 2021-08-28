package baekjoon.twopointer._1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        primeSum(n);
    }

    private static void primeSum(int n) {
        boolean[] arr = new boolean[n + 1];
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i < arr.length; i++) {
            arr[i] = true;
        }
        for (int i = 2; i <= sqrt; i++) {
            for (int j = i * i; j <= n; j += i) {
                arr[j] = false;
            }
        }
        List<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                prime.add(i);
            }
        }
        int answer = 0;
        int a = 0;
        int b = 0;
        int tmp = 0;
        while (true) {
            if (tmp >= n) {
                tmp -= prime.get(a);
                a++;
            } else if (b == prime.size()) {
                break;
            } else {
                tmp += prime.get(b);
                b++;
            }
            if (tmp == n) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
