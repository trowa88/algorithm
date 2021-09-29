package baekjoon.binarysearch._10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] cards = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.readLine();
        int[] target = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(numberCard(cards, target));
    }

    private static String numberCard(int[] cards, int[] target) {
        int[] answer = new int[target.length];
        Set<Integer> set = Arrays.stream(cards)
                .boxed()
                .collect(Collectors.toUnmodifiableSet());
        for (int i = 0; i < target.length; i++) {
            answer[i] = set.contains(target[i]) ? 1 : 0;
        }
        return Arrays.stream(answer)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
