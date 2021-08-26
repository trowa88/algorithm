package baekjoon.string._11719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] buf = new char[10000];
        int read = br.read(buf);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < read; i++) {
            builder.append(buf[i]);
        }
        System.out.print(builder);
    }
}
