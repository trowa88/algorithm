package baekjoon.string._1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (checkGroupWord(br.readLine())) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean checkGroupWord(String s) {
        Set<Character> set = new HashSet<>();
        char last = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (last != s.charAt(i)) {
                if (set.contains(s.charAt(i))) {
                    return false;
                }
                set.add(last);
                last = s.charAt(i);
            }
        }
        return true;
    }
}
