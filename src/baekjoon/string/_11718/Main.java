package baekjoon.string._11718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        char[] chars = new char[10000];
        int read = br.read(chars);
        for (int i = 0; i < read; i++) {
            builder.append(chars[i]);
        }
        System.out.print(builder);
    }
}
