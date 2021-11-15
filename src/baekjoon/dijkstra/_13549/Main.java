package baekjoon.dijkstra._13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int start = arr[0];
        int end = arr[1];
        System.out.println(hideAndSeek(start, end));
    }

    private static int hideAndSeek(int start, int end) {
        boolean[] visit = new boolean[100_001];
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(value -> value[1]));
        visit[start] = true;
        queue.add(new int[]{start, 0});
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int index = poll[0];
            int distance = poll[1];
            visit[index] = true;
            if (index == end) {
                answer = distance;
                break;
            }
            if (index + 1 < 100_001 && !visit[index + 1]) {
                queue.add(new int[]{index + 1, distance + 1});
            }
            if (index - 1 >= 0 && !visit[index - 1]) {
                queue.add(new int[]{index - 1, distance + 1});
            }
            if (index * 2 < 100_001 && !visit[index * 2]) {
                queue.add(new int[]{index * 2, distance});
            }
        }
        return answer;
    }
}
