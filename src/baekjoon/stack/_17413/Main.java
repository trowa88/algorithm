package baekjoon.stack._17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(reverse(s));
    }

    private static String reverse(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        String[] split = s.split("");
        boolean tag = false;
        for (String value : split) {
            if (!tag && value.equals(" ")) {
                while (!stack.isEmpty()) {
                    builder.append(stack.pop());
                }
                builder.append(" ");
            } else if (value.equals(">")) {
                StringBuilder tmp = new StringBuilder();
                while (!stack.isEmpty()) {
                    tmp.insert(0, stack.pop());
                }
                tmp.append(">");
                builder.append(tmp);
                tag = false;
            } else if (value.equals("<")) {
                tag = true;
                while (!stack.isEmpty()) {
                    builder.append(stack.pop());
                }
                stack.push(value);
            } else {
                stack.push(value);
            }
        }
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }
}
