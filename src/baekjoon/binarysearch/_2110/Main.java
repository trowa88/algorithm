package baekjoon.binarysearch._2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] home = new int[arr[0]];
        for (int i = 0; i < home.length; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(router(home, arr[1]));
    }

    private static int router(int[] home, int count) {
        Arrays.sort(home);
        int start = 1;
        int end = home[home.length - 1] - home[0];
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int left = home[0];
            int cnt = 1;
            for (int i = 1; i < home.length; i++) {
                if (home[i] - left >= mid) {
                    cnt++;
                    left = home[i];
                }
            }
            if (cnt >= count) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }
}
