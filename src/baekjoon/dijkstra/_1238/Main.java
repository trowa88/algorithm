package baekjoon.dijkstra._1238;

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
        int n = arr[0];
        int m = arr[1];
        int x = arr[2];
        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int[] s = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            list.get(s[0]).add(new Node(s[1], s[2]));
        }
        int answer = 0;
        int[] comeback = party(list, x);
        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }
            answer = Math.max(answer, party(list, i)[x] + comeback[i]);
        }
        System.out.println(answer);
    }

    private static int[] party(List<List<Node>> list, int start) {
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
