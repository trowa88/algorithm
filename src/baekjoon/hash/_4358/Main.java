package baekjoon.hash._4358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        while (true) {
            String s = br.readLine();
            if (Objects.isNull(s) || s.isEmpty()) {
                break;
            }
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        int total = map.values()
                .stream()
                .mapToInt(value -> value)
                .sum();
        System.out.println(
                map.keySet()
                        .stream()
                        .sorted()
                        .map(s -> String.format("%s %.4f", s, map.get(s) / (double) total * 100))
                        .collect(Collectors.joining("\n"))
        );
    }
}
