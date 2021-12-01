package baekjoon.stack._2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(brackets(s));
    }

    private static int brackets(String s) {
        int sum = 0;
        int tmp = 1;
        Stack<String> stack = new Stack<>();
        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case "(":
                    tmp *= 2;
                    stack.push(arr[i]);
                    break;
                case "[":
                    tmp *= 3;
                    stack.push(arr[i]);
                    break;
                case ")":
                    if (stack.isEmpty() || !stack.peek().equals("(")) {
                        return 0;
                    }
                    if (arr[i - 1].equals("(")) {
                        sum += tmp;
                    }
                    stack.pop();
                    tmp /= 2;
                    break;
                case "]":
                    if (stack.isEmpty() || !stack.peek().equals("[")) {
                        return 0;
                    }
                    if (arr[i - 1].equals("[")) {
                        sum += tmp;
                    }
                    stack.pop();
                    tmp /= 3;
                    break;
            }
        }
        if (!stack.isEmpty()) {
            return 0;
        }
        return sum;
    }
}
