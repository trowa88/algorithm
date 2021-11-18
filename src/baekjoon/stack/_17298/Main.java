package baekjoon.stack._17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(rightBigNumber(arr));
    }

    private static String rightBigNumber(int[] arr) {
        Stack<String> list = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                list.add("-1");
                stack.push(arr[i]);
                continue;
            }
            while (true) {
                if (stack.isEmpty()) {
                    list.add("-1");
                    stack.push(arr[i]);
                    break;
                }
                if (stack.peek() > arr[i]) {
                    list.add(String.valueOf(stack.peek()));
                    stack.push(arr[i]);
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!list.isEmpty()) {
            builder.append(list.pop());
            if (!list.isEmpty()) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
