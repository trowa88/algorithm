package baekjoon.stack._2812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int removeNum = arr[1];

        System.out.println(makeBigger(removeNum, br.readLine()));
    }

    private static String makeBigger(int removeNum, String s) {
        Stack<Integer> stack = new Stack<>();
        for (String ss : s.split("")) {
            int tmp = Integer.parseInt(ss);
            if (stack.isEmpty()) {
                stack.push(tmp);
                continue;
            }
            if (stack.peek() < tmp && removeNum != 0) {
                while (!stack.isEmpty() && stack.peek() < tmp) {
                    stack.pop();
                    removeNum--;
                    if (removeNum == 0) {
                        break;
                    }
                }
                stack.push(tmp);
            } else {
                stack.push(tmp);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            if (removeNum > 0) {
                stack.pop();
                removeNum--;
            } else {
                builder.insert(0, stack.pop());
            }
        }
        return builder.toString();
    }
}
