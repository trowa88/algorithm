package baekjoon.twopointer._1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int target = Integer.parseInt(s[1]);
        int[] s1 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(partSum(s1, target));
    }

    private static int partSum(int[] s1, int target) {
        int answer = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        int tmp = 0;
        while (true) {
            if (tmp >= target) {
                tmp -= s1[a];
                a++;
            } else if (b == s1.length) {
                break;
            } else {
                tmp += s1[b];
                b++;
            }
            if (tmp >= target) {
                System.out.printf("%s %s\n", a, b);
                answer = Integer.min(answer, b - a);
            }
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
