package baekjoon.hash._1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int pocketmonCount = Integer.parseInt(s[0]);
        int questionCount = Integer.parseInt(s[1]);
        String[] pocketmon = new String[pocketmonCount + 1];
        String[] questions = new String[questionCount];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < pocketmonCount; i++) {
            String name = br.readLine();
            pocketmon[i + 1] = name;
            map.put(name, i + 1);
        }
        for (int i = 0; i < questionCount; i++) {
            questions[i] = br.readLine();
        }
        answer(pocketmon, questions, map);
    }

    private static void answer(String[] pocketmon, String[] questions, Map<String, Integer> map) {
        for (String question : questions) {
            try {
                System.out.println(pocketmon[Integer.parseInt(question)]);
            } catch (NumberFormatException e) {
                System.out.println(map.get(question));
            }
        }
    }
}
