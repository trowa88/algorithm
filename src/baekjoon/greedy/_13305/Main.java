package baekjoon.greedy._13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] city = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] oil = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(oilStation(city, oil));
    }

    private static long oilStation(int[] city, int[] oil) {
        long answer = 0;
        int oilPrice = oil[0];
        for (int i = 0; i < city.length; i++) {
            oilPrice = Math.min(oilPrice, oil[i]);
            answer += (long) city[i] * oilPrice;
        }
        return answer;
    }
}
