package baekjoon.hash._17219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n[0]; i++) {
            String[] s = br.readLine().split(" ");
            map.put(s[0], s[1]);
        }
        List<String> passwords = new ArrayList<>();
        for (int i = 0; i < n[1]; i++) {
            String s = br.readLine();
            passwords.add(map.get(s));
        }
        String answer = String.join("\n", passwords);
        System.out.println(answer);
    }
}
