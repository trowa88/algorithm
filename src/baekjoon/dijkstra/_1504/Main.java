package baekjoon.dijkstra._1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i < arr[0] + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < arr[1]; i++) {
            int[] s = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            list.get(s[0]).add(new Node(s[1], s[2]));
            list.get(s[1]).add(new Node(s[0], s[2]));
        }
        int[] must = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int x = must[0];
        int y = must[1];
        int answerX;
        int answerY;
        int[] start = dijkstra(list, 1);
        int[] m1 = dijkstra(list, x);
        int[] m2 = dijkstra(list, y);

        if (start[y] == Integer.MAX_VALUE) {
            answerX = -1;
        } else {
            answerX = start[y];
            if (m2[x] == Integer.MAX_VALUE) {
                answerX = -1;
            } else {
                answerX += m2[x];
                if (m1[arr[0]] == Integer.MAX_VALUE) {
                    answerX = -1;
                } else {
                    answerX += m1[arr[0]];
                }
            }
        }

        if (start[x] == Integer.MAX_VALUE) {
            answerY = -1;
        } else {
            answerY = start[x];
            if (m1[y] == Integer.MAX_VALUE) {
                answerY = -1;
            } else {
                answerY += m1[y];
                if (m2[arr[0]] == Integer.MAX_VALUE) {
                    answerY = -1;
                } else {
                    answerY += m2[arr[0]];
                }
            }
        }
        System.out.println(Math.min(answerX, answerY));
    }

    private static int[] dijkstra(List<List<Node>> list, int start) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        int[] d = new int[list.size()];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int index = poll.getIndex();
            int distance = poll.getDistance();
            if (d[index] < distance) {
                continue;
            }
            for (Node node : list.get(index)) {
                int newDistance = distance + node.getDistance();
                if (d[node.getIndex()] > newDistance) {
                    d[node.getIndex()] = newDistance;
                    queue.add(new Node(node.getIndex(), newDistance));
                }
            }
        }
        return d;
    }

    private static class Node {
        private final int index;
        private final int distance;

        private Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }
    }
}
