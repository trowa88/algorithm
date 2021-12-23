package baekjoon.greedy._1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(sortCard(arr));
    }

    private static int sortCard(int[] arr) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.add(i);
        }
        int answer = 0;
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                break;
            }
            Integer a = queue.poll();
            Integer b = Objects.requireNonNullElse(queue.poll(), 0);
            answer += a + b;
            queue.add(a + b);
        }
        return answer;
    }
}
