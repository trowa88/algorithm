package baekjoon.stack._5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println(keyLogger(br.readLine()));
        }
    }

    private static String keyLogger(String readLine) {
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        String[] split = readLine.split("");
        for (String s : split) {
            switch (s) {
                case "<":
                    if (pre.isEmpty()) {
                        continue;
                    }
                    post.push(pre.pop());
                    break;
                case ">":
                    if (post.isEmpty()) {
                        continue;
                    }
                    pre.push(post.pop());
                    break;
                case "-":
                    if (pre.isEmpty()) {
                        continue;
                    }
                    pre.pop();
                    break;
                default:
                    pre.push(s);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!post.isEmpty()) {
            pre.push(post.pop());
        }
        for (int i = 0; i < pre.size(); i++) {
            builder.append(pre.elementAt(i));
        }
        return builder.toString();
    }
}
