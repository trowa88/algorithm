package baekjoon.hash._11478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(count(s));
    }

    private static int count(String s) {
        Set<String> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            builder.setLength(0);
            for (int j = i; j < s.length(); j++) {
                set.add(builder.append(s.charAt(j)).toString());
            }
        }
        return set.size();
    }
}
