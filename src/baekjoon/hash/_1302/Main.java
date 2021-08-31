package baekjoon.hash._1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (map.containsKey(s)) {
                max = Math.max(max, map.get(s) + 1);
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        int finalMax = max;
        map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == finalMax)
                .min(Map.Entry.comparingByKey())
                .ifPresent(entry -> System.out.println(entry.getKey()));
    }
}
