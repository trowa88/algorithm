package baekjoon.tree._11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[n + 1];
        List<List<Integer>> list = new ArrayList<>();
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int a = arr[0];
            int b = arr[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        dfs(list, 1, visit, parent);
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(List<List<Integer>> lists, int i, boolean[] visit, int[] parent) {
        if (visit[i]) {
            return;
        }
        visit[i] = true;
        for (int j = 0; j < lists.get(i).size(); j++) {
            int a = lists.get(i).get(j);
            if (!visit[a] && parent[a] == 0) {
                parent[a] = i;
                dfs(lists, a, visit, parent);
            }
        }
    }
}
