package baekjoon.dijkstra._1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int INF = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int count = Integer.parseInt(s[1]);
        int start = Integer.parseInt(br.readLine());
        int[] d = new int[n + 1];
        Arrays.fill(d, INF);
        List<Node>[] list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < count; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            list[arr[0]].add(new Node(arr[1], arr[2]));
        }
        dijkstra(list, start, d);
        for (int i = 1; i < d.length; i++) {
            System.out.println(d[i] == INF ? "INF" : d[i]);
        }
    }

    private static void dijkstra(List<Node>[] list, int start, int[] d) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        d[start] = 0;
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.getDistance() > d[node.getIndex()]) {
                continue;
            }
            for (Node n : list[node.getIndex()]) {
                int distance = n.getDistance() + node.getDistance();
                if (d[n.getIndex()] > distance) {
                    d[n.getIndex()] = distance;
                    queue.add(new Node(n.getIndex(), distance));
                }
            }
        }
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
