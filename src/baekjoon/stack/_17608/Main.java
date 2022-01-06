package baekjoon.stack._17608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(stick(arr));
    }

    private static int stick(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            stack.push(i);
        }
        Integer i = stack.pop();
        int answer = 1;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (pop > i) {
                answer++;
                i = pop;
            }
        }
        return answer;
    }
}
