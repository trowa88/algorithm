package baekjoon.stack._12605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        System.out.println(reverse(arr));
    }

    private static String reverse(String[] str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            Stack<String> stack = new Stack<>();
            for (String s : str[i].split(" ")) {
                stack.push(s);
            }
            builder.append(String.format("Case #%s: ", i + 1));
            while (!stack.isEmpty()) {
                builder.append(stack.pop());
                if (!stack.isEmpty()) {
                    builder.append(" ");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
