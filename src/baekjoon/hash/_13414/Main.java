package baekjoon.hash._13414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = rr[0];
        int n = rr[1];
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            set.remove(name);
            set.add(name);
        }
        System.out.println(
                set.stream()
                        .limit(target)
                        .collect(Collectors.joining("\n"))
        );
    }
}
