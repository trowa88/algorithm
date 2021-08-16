package baekjoon.stack._10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<Integer> stack = new ArrayList<>();
    private static int index = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            command(br.readLine());
        }
    }

    private static void command(String s) {
        String[] s1 = s.split(" ");
        if (s1.length == 2) {
            stack.add(Integer.parseInt(s1[1]));
            index++;
        } else {
            switch (s1[0]) {
                case "pop":
                    if (index == -1) {
                        System.out.println(-1);
                    } else {
                        Integer remove = stack.remove(index);
                        System.out.println(remove);
                        index--;
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(index == -1 ? 1 : 0);
                    break;
                case "top":
                    if (index == -1) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.get(index));
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
}
