package baekjoon.stack._1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(postfix(s));
    }

    private static String postfix(String s) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                builder.append(c);
            } else {
                switch (c) {
                    case '(':
                        st.push(c);
                        break;
                    case '*':
                    case '/':
                        while (!st.isEmpty() && (st.peek() == '*' || st.peek() == '/')) {
                            builder.append(st.peek());
                            st.pop();
                        }
                        st.push(c);
                        break;
                    case '+':
                    case '-':
                        while (!st.isEmpty() && st.peek() != '(') {
                            builder.append(st.peek());
                            st.pop();
                        }
                        st.push(c);
                        break;
                    case ')':
                        while (!st.isEmpty() && st.peek() != '(') {
                            builder.append(st.peek());
                            st.pop();
                        }
                        if (!st.isEmpty() && st.peek() == '(') {
                            st.pop();
                        }
                    default:
                }
            }
        }
        while (!st.isEmpty()) {
            builder.append(st.peek());
            st.pop();
        }
        return builder.toString();
    }
}
