package baekjoon.hash._2776;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            br.readLine();
            Set<Integer> one = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toSet());
            br.readLine();
            int[] two = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < two.length; j++) {
                builder.append(
                        one.contains(two[j]) ? 1 : 0
                );
                if (j != two.length - 1) {
                    builder.append("\n");
                }
            }
            System.out.println(builder);
        }
    }
}
