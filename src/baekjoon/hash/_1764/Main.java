package baekjoon.hash._1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        String[] hear = new String[Integer.parseInt(s[0])];
        String[] see = new String[Integer.parseInt(s[1])];
        for (int i = 0; i < hear.length; i++) {
            hear[i] = br.readLine();
        }
        for (int i = 0; i < see.length; i++) {
            see[i] = br.readLine();
        }
        hearSee(hear, see);
    }

    private static void hearSee(String[] hear, String[] see) {
        Set<String> seeSet = Arrays.stream(see)
                .collect(Collectors.toSet());
        List<String> list = new ArrayList<>();
        int answer = 0;
        for (String s : hear) {
            if (seeSet.contains(s)) {
                answer++;
                list.add(s);
            }
        }
        System.out.println(answer);
        System.out.println(
                list.stream().sorted().collect(Collectors.joining("\n"))
        );
    }
}
