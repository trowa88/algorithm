package baekjoon.string._2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(croatiaAlphabet(s));
    }

    private static int croatiaAlphabet(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == s.length() - 1) {
                answer++;
                return answer;
            }
            switch (c) {
                case 'c':
                    if (s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-') {
                        answer++;
                        i++;
                    } else {
                        answer++;
                    }
                    break;
                case 'd':
                    if (s.charAt(i + 1) == 'z') {
                        if (i + 2 <= s.length() - 1 && s.charAt(i + 2) == '=') {
                            answer++;
                            i += 2;
                        } else {
                            answer++;
                        }
                    } else if (s.charAt(i + 1) == '-') {
                        answer++;
                        i++;
                    } else {
                        answer++;
                    }
                    break;
                case 'l':
                case 'n':
                    if (s.charAt(i + 1) == 'j') {
                        answer++;
                        i++;
                    } else {
                        answer++;
                    }
                    break;
                case 's':
                case 'z':
                    if (s.charAt(i + 1) == '=') {
                        answer++;
                        i++;
                    } else {
                        answer++;
                    }
                    break;
                default:
                    answer++;
            }
        }
        return answer;
    }
}
