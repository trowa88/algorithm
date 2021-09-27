package baekjoon.queue._1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] priority = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(printerQueue(arr, priority));
        }
    }

    private static int printerQueue(int[] arr, int[] priority) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr[0]; i++) {
            queue.add(i);
        }
        int answer = 0;
        while (!queue.isEmpty()) {
            int max = max(priority);
            if (priority[Objects.requireNonNull(queue.peek())] == max) {
                Integer poll = queue.poll();
                priority[poll] = -1;
                answer++;
                if (poll == arr[1]) {
                    break;
                }
            } else {
                queue.add(queue.poll());
            }
        }
        return answer;
    }

    private static int max(int[] priority) {
        int tmp = 0;
        for (int j : priority) {
            tmp = Integer.max(tmp, j);
        }
        return tmp;
    }
}
