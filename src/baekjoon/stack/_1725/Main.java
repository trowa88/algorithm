package baekjoon.stack._1725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(histogram(arr));
    }

    private static long histogram(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        long answer = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int index = stack.pop();
                int w = stack.isEmpty() ? i : i - 1 - stack.peek();
                answer = Math.max(answer, (long) w * arr[index]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int w = stack.isEmpty() ? arr.length : arr.length - 1 - stack.peek();
            answer = Math.max(answer, (long) w * arr[index]);
        }
        return answer;
    }
}
