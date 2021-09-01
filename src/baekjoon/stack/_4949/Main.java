package baekjoon.stack._4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }
            check(s);

        }
    }

    private static void check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(') {
                stack.add(c);
            } else if (c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    System.out.println("no");
                    return;
                }
                if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    System.out.println("no");
                    return;
                }
            }
        }
        System.out.println(
                stack.isEmpty()
                        ? "yes"
                        : "no"
        );
    }
}
