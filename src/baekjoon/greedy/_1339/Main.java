package baekjoon.greedy._1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        System.out.println(wordMath(arr));
    }

    private static int wordMath(String[] arr) {
        int[] alphabet = new int[26];
        for (String s : arr) {
            int tmp = (int) Math.pow(10, s.length() - 1);
            for (int j = 0; j < s.length(); j++) {
                alphabet[s.charAt(j) - 'A'] += tmp;
                tmp /= 10;
            }
        }
        int answer = 0;
        int n = 9;
        int[] sorted = Arrays.stream(alphabet)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(value -> value)
                .toArray();
        for (int i : sorted) {
            answer += i * n--;
        }
        return answer;
    }
}
