package baekjoon.sort._1181;

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
        Set<String> list = new HashSet<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        System.out.println(
                list.stream()
                        .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                        .collect(Collectors.joining("\n"))
        );
    }
}
