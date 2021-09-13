package baekjoon.priorityqueue._11279;

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
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a != 0) {
                pq.add(a);
            } else {
                System.out.println(
                        pq.isEmpty()
                                ? 0
                                : pq.poll()
                );
            }
        }
    }
}
