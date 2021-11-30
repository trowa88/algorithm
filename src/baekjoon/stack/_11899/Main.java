package baekjoon.stack._11899;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < readLine.length(); i++) {
            if (readLine.charAt(i) == '(') {
                stack.push(readLine.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    answer++;
                } else if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            answer++;
            stack.pop();
        }
        System.out.println(answer);
    }
}
