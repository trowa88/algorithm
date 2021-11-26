package baekjoon.hash._2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Map<Integer, Integer> index = new HashMap<>();
        Map<Integer, Integer> frequency = new HashMap<>();
        int idx = 0;
        for (int num : arr) {
            if (!index.containsKey(num)) {
                index.put(num, idx++);
            }
            if (frequency.containsKey(num)) {
                frequency.put(num, frequency.get(num) + 1);
            } else {
                frequency.put(num, 1);
            }
        }
        System.out.println(
                Arrays.stream(arr)
                        .boxed()
                        .sorted(Comparator.comparingInt(frequency::get).reversed()
                                .thenComparingInt(index::get))
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))
        );
    }
}
