package baekjoon.twopointer._3273;

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
        int target = Integer.parseInt(br.readLine());
        System.out.println(twoSum(arr, target));
    }

    private static int twoSum(int[] arr, int target) {
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;
        int answer = 0;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == target) {
                answer++;
                l++;
                r--;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return answer;
    }
}
