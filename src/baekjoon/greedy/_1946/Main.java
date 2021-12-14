package baekjoon.greedy._1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int count = Integer.parseInt(br.readLine());
            int[][] arr = new int[count][2];
            for (int j = 0; j < count; j++) {
                int[] s = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                arr[j][0] = s[0];
                arr[j][1] = s[1];
            }
            System.out.println(newEmployee(arr));
        }
    }

    private static int newEmployee(int[][] arr) {
        int[][] sorted = Arrays.stream(arr)
                .sorted(Comparator.comparingInt(value -> value[0]))
                .toArray(int[][]::new);
        int interview = sorted[0][1];
        int answer = 1;
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i][1] <= interview) {
                interview = sorted[i][1];
                answer++;
            }
        }
        return answer;
    }
}
