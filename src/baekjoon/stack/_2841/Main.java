package baekjoon.stack._2841;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = arr[0];
        int flat = arr[1];
        int[][] g = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            g[i][0] = Integer.parseInt(s[0]);
            g[i][1] = Integer.parseInt(s[1]);
        }
        System.out.println(alienGuitar(g, flat));
    }

    private static int alienGuitar(int[][] g, int flat) {
        int answer = 0;
        List<Stack<Integer>> stacks = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            stacks.add(new Stack<>());
        }
        for (int[] ints : g) {
            int l = ints[0];
            int f = ints[1];
            while (!stacks.get(l).isEmpty() && stacks.get(l).peek() > f) {
                stacks.get(l).pop();
                answer++;
            }
            if (stacks.get(l).isEmpty() || (!stacks.get(l).isEmpty() && stacks.get(l).peek() < f)) {
                stacks.get(l).push(f);
                answer++;
            }
        }
        return answer;
    }
}
