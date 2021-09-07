package baekjoon.greedy._10162;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(
                Arrays.stream(microwaveOven(n))
                        .boxed()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "))
        );
    }

    private static int[] microwaveOven(int n) {
        int[] arr = new int[3];
        while (n != 0) {
            if (n >= 300) {
                arr[0] = n / 300;
                n %= 300;
            } else if (n >= 60) {
                arr[1] = n / 60;
                n %= 60;
            } else if (n >= 10) {
                arr[2] = n / 10;
                n %= 10;
            } else {
                return new int[]{-1};
            }
        }
        return arr;
    }
}
