package baekjoon.stack._6549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            if (n == 0) {
                break;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            System.out.println(histogram(arr));
        }
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
