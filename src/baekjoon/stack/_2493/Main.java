package baekjoon.stack._2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(top(arr));
    }

    private static String top(int[] arr) {
        Stack<int[]> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                list.add("0");
                stack.push(new int[]{arr[i], i + 1});
                continue;
            }
            while (true) {
                if (stack.isEmpty()) {
                    list.add("0");
                    stack.push(new int[]{arr[i], i + 1});
                    break;
                }
                if (stack.peek()[0] > arr[i]) {
                    list.add(String.valueOf(stack.peek()[1]));
                    stack.push(new int[]{arr[i], i + 1});
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        return String.join(" ", list);
    }
}
