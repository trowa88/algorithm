package baekjoon.hash._7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> office = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            if (s[1].equals("enter")) {
                office.add(s[0]);
            } else {
                office.remove(s[0]);
            }
        }

        for (String s : office.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())) {
            System.out.println(s);
        }
    }
}
