package baekjoon.hash._1269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        Set<Integer> one = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> two = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());
        int answer;
        if (one.size() < two.size()) {
            answer = symmetryDifference(one, two);
        } else {
            answer = symmetryDifference(two, one);
        }
        System.out.println(answer);
    }

    private static int symmetryDifference(Set<Integer> one, Set<Integer> two) {
        Set<Integer> tmp = new HashSet<>(one);
        for (Integer n : tmp) {
            if (two.contains(n)) {
                two.remove(n);
                one.remove(n);
            }
        }
        return one.size() + two.size();
    }
}
