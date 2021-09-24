package baekjoon.queue._10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue(br.readLine(), queue);
        }
    }

    private static void queue(String str, Deque<Integer> queue) {
        String[] s = str.split(" ");
        String command = s[0];
        switch (command) {
            case "push":
                queue.add(Integer.parseInt(s[1]));
                break;
            case "front":
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.peek());
                }
                break;
            case "back":
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.getLast());
                }
                break;
            case "size":
                System.out.println(queue.size());
                break;
            case "empty":
                System.out.println(queue.isEmpty() ? 1 : 0);
                break;
            case "pop":
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.poll());
                }
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
