package baekjoon.hash._1351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long n = arr[0];
        long p = arr[1];
        long q = arr[2];
        Map<Long, Long> map = new HashMap<>();
        System.out.println(getNum(n, p, q, map));
    }

    private static Long getNum(long n, long p, long q, Map<Long, Long> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 1L;
        }
        long a = n / p;
        long b = n / q;
        map.put(n, getNum(a, p, q, map) + getNum(b, p, q, map));
        return map.get(n);
    }
}
