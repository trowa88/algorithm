package baekjoon.dijkstra._18352;

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
        int d = arr[1];
        int target = arr[2];
        int start = arr[3];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < d; i++) {
            int[] aa = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            list.get(aa[0]).add(aa[1]);
        }
        System.out.println(findCity(list, start, target));
    }

    private static String findCity(List<List<Integer>> list, int start, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        int[] distance = new int[list.size()];
        distance[start] = 0;
        Arrays.fill(distance, Integer.MAX_VALUE);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int a = poll[0];
            int d = poll[1];
            if (d > distance[a]) {
                continue;
            }
            distance[a] = d;
            for (Integer n : list.get(a)) {
                if (d + 1 < distance[n]) {
                    queue.add(new int[]{n, d + 1});
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == target) {
                builder.append(i);
                if (i != distance.length - 1) {
                    builder.append("\n");
                }
            }
        }
        return builder.length() == 0 ? "-1" : builder.toString();
    }
}
