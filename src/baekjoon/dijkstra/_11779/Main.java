package baekjoon.dijkstra._11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());
        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < bus; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            list.get(arr[0]).add(new Node(arr[1], arr[2]));
        }
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int start = arr[0];
        int end = arr[1];
        dijkstra(list, start, end);
    }

    private static void dijkstra(List<List<Node>> list, int start, int end) {
        int[] d = new int[list.size()];
        int[] visit = new int[list.size()];
        Arrays.fill(d, Integer.MAX_VALUE);
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        d[start] = 0;
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (d[node.getIndex()] < node.getDistance()) {
                continue;
            }
            for (Node n : list.get(node.getIndex())) {
                int distance = n.getDistance() + node.getDistance();
                if (d[n.getIndex()] > distance) {
                    d[n.getIndex()] = distance;
                    visit[n.getIndex()] = node.getIndex();
                    queue.add(new Node(n.getIndex(), distance));
                }
            }
        }
        System.out.println(d[end]);
        Stack<Integer> visited = new Stack<>();
        int tmp = end;
        while (tmp != 0) {
            visited.push(tmp);
            tmp = visit[tmp];
        }
        System.out.println(visited.size());
        StringBuilder builder = new StringBuilder();
        while (!visited.isEmpty()) {
            builder.append(visited.pop());
            if (!visited.isEmpty()) {
                builder.append(" ");
            }
        }
        System.out.println(builder);
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
