package baekjoon.queue._1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(josephus(arr));
    }

    public static String josephus(int[] arr) {
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 1; i <= arr[0]; i++) {
            q1.add(i);
        }
        int target = arr[1];
        int i = 1;
        StringBuilder builder = new StringBuilder("<");
        while (!q1.isEmpty()) {
            if (i == target) {
                builder.append(q1.poll());
                if (!q1.isEmpty()) {
                    builder.append(", ");
                }
                i = 0;
            } else {
                q1.add(q1.poll());
            }
            i++;
        }
        builder.append(">");
        return builder.toString();
    }
}
