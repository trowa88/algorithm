package baekjoon.hash._1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(good(arr));
    }

    private static int good(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];
            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (target == sum) {
                    if (left != i && right != i) {
                        answer++;
                        break;
                    } else if (left == i) {
                        left++;
                    } else {
                        right--;
                    }
                } else if (target > sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return answer;
    }
}
