package baekjoon.hash._2002;

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
        int index = 0;
        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), index++);
        }
        int answer = 0;
        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            out[i] = map.get(s);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (out[i] > out[j]) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
