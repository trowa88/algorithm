package baekjoon.recursion._1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[][] arr = new String[count][3];
        for (int i = 0; i < count; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = s[0];
            arr[i][1] = s[1];
            arr[i][2] = s[2];
        }
        preOrder(arr, arr[0]);
        System.out.println();
        inOrder(arr, arr[0]);
        System.out.println();
        postOrder(arr, arr[0]);
    }

    private static void preOrder(String[][] arr, String[] target) {
        System.out.print(target[0]);
        if (!target[1].equals(".")) {
            preOrder(arr, arr[find(arr, target[1])]);
        }
        if (!target[2].equals(".")) {
            preOrder(arr, arr[find(arr, target[2])]);
        }
    }

    private static void inOrder(String[][] arr, String[] target) {
        if (!target[1].equals(".")) {
            inOrder(arr, arr[find(arr, target[1])]);
        }
        System.out.print(target[0]);
        if (!target[2].equals(".")) {
            inOrder(arr, arr[find(arr, target[2])]);
        }
    }

    private static void postOrder(String[][] arr, String[] target) {
        if (!target[1].equals(".")) {
            postOrder(arr, arr[find(arr, target[1])]);
        }
        if (!target[2].equals(".")) {
            postOrder(arr, arr[find(arr, target[2])]);
        }
        System.out.print(target[0]);
    }

    private static int find(String[][] arr, String s) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0].equals(s)) {
                return i;
            }
        }
        return -1;
    }
}
