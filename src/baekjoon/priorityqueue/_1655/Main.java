package baekjoon.priorityqueue._1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (max.size() == min.size()) {
                max.add(a);
            } else if (max.size() > min.size()) {
                min.add(a);
            }
            if (!max.isEmpty() && !min.isEmpty() && max.peek() > min.peek()) {
                Integer ma = max.poll();
                Integer mi = min.poll();
                max.add(mi);
                min.add(ma);
            }
            answer.append(max.peek()).append("\n");
        }
        System.out.println(answer);
    }
}
