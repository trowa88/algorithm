package baekjoon.hash._11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        System.out.println(
                map.entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                                .thenComparing(stringIntegerEntry -> Long.parseLong(stringIntegerEntry.getKey())))
                        .limit(1)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList())
                        .get(0)
        );
    }
}
