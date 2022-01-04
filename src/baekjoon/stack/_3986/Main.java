package baekjoon.stack._3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += goodWord(br.readLine());
        }
        System.out.println(answer);
    }

    private static int goodWord(String s) {
        Stack<String> stack = new Stack<>();
        for (String s1 : s.split("")) {
            if (!stack.isEmpty() && stack.peek().equals(s1)) {
                stack.pop();
            } else {
                stack.push(s1);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
