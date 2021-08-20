package baekjoon.string._1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(
                Arrays.stream(br.readLine().split(" "))
                        .filter(s -> !s.equals(""))
                        .count()
        );
    }
}
