package baekjoon.greedy._5585;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(br.readLine());
        System.out.println(change(1000, amount));
    }

    private static int change(int i, int amount) {
        int answer = 0;
        int change = i - amount;
        while (change != 0) {
            if (change >= 500) {
                answer += change / 500;
                change %= 500;
            } else if (change >= 100) {
                answer += change / 100;
                change %= 100;
            } else if (change >= 50) {
                answer += change / 50;
                change %= 50;
            } else if (change >= 10) {
                answer += change / 10;
                change %= 10;
            } else if (change >= 5) {
                answer += change / 5;
                change %= 5;
            } else {
                answer += change;
                change %= 1;
            }
        }
        return answer;
    }
}
