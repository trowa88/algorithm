package baekjoon.stack._1874;

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
        System.out.print(sequence(arr));

    }

    private static String sequence(int[] arr) {
        StringBuilder builder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int v = 1;
        for (int i : arr) {
            if (!stack.isEmpty() && stack.peek() > i) {
                return "NO";
            }
            while (stack.isEmpty() || stack.peek() != i) {
                stack.push(v);
                v++;
                builder.append("+\n");
            }
            stack.pop();
            builder.append("-\n");
        }
        while (!stack.isEmpty()) {
            stack.pop();
            builder.append("-\n");
        }
        return builder.toString().trim();
    }
}
