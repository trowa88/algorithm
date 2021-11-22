package baekjoon.hash._4195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static int[] parent;
    private static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(br.readLine());
            parent = new int[c * 2];
            for (int j = 0; j < parent.length; j++) {
                parent[j] = j;
            }
            count = new int[c * 2];
            Arrays.fill(count, 1);
            Map<String, Integer> map = new HashMap<>();
            int index = 0;
            for (int j = 0; j < c; j++) {
                String[] s = br.readLine().split(" ");
                if (!map.containsKey(s[0])) {
                    map.put(s[0], index++);
                }
                if (!map.containsKey(s[1])) {
                    map.put(s[1], index++);
                }
                System.out.println(
                        union(
                                map.get(s[0]),
                                map.get(s[1])
                        )
                );
            }
        }
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static int union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a > b) {
                parent[a] = b;
                count[b] += count[a];
                return count[b];
            } else {
                parent[b] = a;
                count[a] += count[b];
                return count[a];
            }
        }
        return count[a];
    }
}
