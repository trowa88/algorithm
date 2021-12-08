package baekjoon.stack._9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();
        System.out.println(stringExplosion(s, bomb));
    }

    private static String stringExplosion(String s, String bomb) {
        Stack<String> stack = new Stack<>();
        for (String ss : s.split("")) {
            stack.push(ss);
            if (stack.size() >= bomb.length()) {
                boolean same = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (!stack.get(stack.size() - bomb.length() + j).equals(String.valueOf(bomb.charAt(j)))) {
                        same = false;
                        break;
                    }
                }
                if (same) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return "FRULA";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            builder.append(stack.elementAt(i));
        }
        return builder.toString();
    }
}
