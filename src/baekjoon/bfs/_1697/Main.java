package baekjoon.bfs._1697;

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
        boolean[] visit = new boolean[100001];
        System.out.println(hideAndSeek(arr, visit));
    }

    private static int hideAndSeek(int[] arr, boolean[] visit) {
        Queue<int[]> queue = new LinkedList<>();
        int start = arr[0];
        int target = arr[1];
        visit[start] = true;
        int time = 0;
        queue.add(new int[]{start, time});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            start = poll[0];
            time = poll[1];
            if (start == target) {
                break;
            }
            if (start + 1 <= 100_000 && !visit[start + 1]) {
                visit[start + 1] = true;
                queue.add(new int[]{start + 1, time + 1});
            }
            if (start - 1 >= 0 && !visit[start - 1]) {
                visit[start - 1] = true;
                queue.add(new int[]{start - 1, time + 1});
            }
            if (start * 2 <= 100_000 && !visit[start * 2]) {
                visit[start * 2] = true;
                queue.add(new int[]{start * 2, time + 1});
            }
        }
        return time;
    }
}
