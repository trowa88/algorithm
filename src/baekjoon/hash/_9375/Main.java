package baekjoon.hash._9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int test = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < test; j++) {
                String[] s = br.readLine().split(" ");
                if (!map.containsKey(s[1])) {
                    map.put(s[1], 2);
                } else {
                    map.put(s[1], map.get(s[1]) + 1);
                }
            }
            System.out.println(passion(map));
        }
    }

    private static int passion(Map<String, Integer> map) {
        int i = map.values()
                .stream()
                .mapToInt(value -> value)
                .reduce((left, right) -> left * right)
                .orElse(0);
        return i == 0 ? 0 : i - 1;
    }
}
