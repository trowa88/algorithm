package baekjoon.twopointer._7453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];
        long[] b = new long[n];
        long[] c = new long[n];
        long[] d = new long[n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            a[i] = Long.parseLong(s[0]);
            b[i] = Long.parseLong(s[1]);
            c[i] = Long.parseLong(s[2]);
            d[i] = Long.parseLong(s[3]);
        }

        sumZero(a, b, c, d);
    }

    private static void sumZero(long[] a, long[] b, long[] c, long[] d) {
        long[] ab = new long[a.length * b.length];
        long[] cd = new long[a.length * b.length];
        int idx = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                ab[idx] = a[i] + b[j];
                cd[idx] = c[i] + d[j];
                idx++;
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);
        long answer = 0;
        int l = 0;
        int r = cd.length - 1;
        while (l < ab.length && r >= 0) {
            long abDuplicate = 0;
            long cdDuplicate = 0;
            if (ab[l] + cd[r] == 0) {
                long abSum = ab[l];
                long cdSum = cd[r];
                while (l < ab.length && ab[l] == abSum) {
                    abDuplicate++;
                    l++;
                }
                while (r >= 0 && cd[r] == cdSum) {
                    cdDuplicate++;
                    r--;
                }
                answer += abDuplicate * cdDuplicate;
            } else if (ab[l] + cd[r] > 0) {
                r--;
            } else {
                l++;
            }
        }
        System.out.println(answer);
    }
}
