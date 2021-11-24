package baekjoon.hash._5568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Set<String> set = new HashSet<>();
        boolean[] visit = new boolean[n];
        dfs(count, arr, set, "", visit);
        System.out.println(set.size());
    }

    private static void dfs(int count, int[] arr, Set<String> set, String s, boolean[] visit) {
        if (count == 0) {
            set.add(s);
            return;
        }
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(count - 1, arr, set, s + arr[i], visit);
                visit[i] = false;
            }
        }
    }
}
