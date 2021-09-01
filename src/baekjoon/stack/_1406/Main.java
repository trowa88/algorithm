package baekjoon.stack._1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        System.out.println(editor(s, arr));
    }

    private static String editor(String s, String[] arr) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        Stack<Character> rightStack = new Stack<>();
        for (String command : arr) {
            String[] s1 = command.split(" ");
            if (s1.length == 1) {
                switch (s1[0]) {
                    case "L":
                        if (!stack.isEmpty()) {
                            rightStack.push(stack.pop());
                        }
                        break;
                    case "D":
                        if (!rightStack.isEmpty()) {
                            stack.push(rightStack.pop());
                        }
                        break;
                    case "B":
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                        break;
                    default:
                        throw new IllegalStateException();
                }
            } else {
                stack.push(s1[1].charAt(0));
            }
        }
        while (!stack.isEmpty()) {
            rightStack.push(stack.pop());
        }
        StringBuilder answer = new StringBuilder();
        while (!rightStack.isEmpty()) {
            answer.append(rightStack.pop());
        }
        return answer.toString();
    }
}
