package baekjoon.bruteforce._2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = arr[1];
        int[] cards = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(blackjack(cards, target));
    }

    private static int blackjack(int[] cards, int target) {
        int max = 0;
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    int tmp = cards[i] + cards[j] + cards[k];
                    if (tmp <= target) {
                        max = Math.max(max, tmp);
                    }
                }
            }
        }
        return max;
    }
}
