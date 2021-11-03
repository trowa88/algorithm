package baekjoon.dijkstra._1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            list.get(arr[0]).add(new Node(arr[1], arr[2]));
        }
        int[] array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int start = array[0];
        int end = array[1];
        System.out.println(dijkstra(list, start, end, d));
    }

    private static int dijkstra(List<List<Node>> list, int start, int end, int[] d) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        d[start] = 0;
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int index = poll.getIndex();
            int distance = poll.getDistance();
            if (distance > d[index]) {
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
        return d[end];
    }

    public static class Node {
        private final int index;
        private final int distance;

        public Node(int index, int distance) {
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
