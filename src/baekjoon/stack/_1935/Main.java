package baekjoon.stack._1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        String exp = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.printf("%.2f", expression(exp, arr));
    }

    private static double expression(String exp, double[] arr) {
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '*'
                    || exp.charAt(i) == '+'
                    || exp.charAt(i) == '/'
                    || exp.charAt(i) == '-') {
                double n1 = stack.pop();
                double n2 = stack.pop();
                switch (exp.charAt(i)) {
                    case '*':
                        stack.push(n2 * n1);
                        break;
                    case '+':
                        stack.push(n2 + n1);
                        break;
                    case '-':
                        stack.push(n2 - n1);
                        break;
                    case '/':
                        stack.push(n2 / n1);
                        break;
                    default:
                }
            } else {
                stack.push(arr[exp.charAt(i) - 'A']);
            }
        }
        return stack.pop();
    }
}
