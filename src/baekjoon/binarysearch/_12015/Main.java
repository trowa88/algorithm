package baekjoon.binarysearch._12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i : arr) {
            if (list.get(list.size() - 1) < i) {
                list.add(i);
            } else {
                int left = 1;
                int right = list.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) > i) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                list.set(right, i);
            }
        }
        System.out.println(list.size() - 1);
    }

}
