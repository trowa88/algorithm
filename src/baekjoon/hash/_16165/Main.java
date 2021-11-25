package baekjoon.hash._16165;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = arr[0];
        int question = arr[1];
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String groupName = br.readLine();
            if (!map.containsKey(groupName)) {
                map.put(groupName, new HashSet<>());
            }
            int memberCount = Integer.parseInt(br.readLine());
            for (int j = 0; j < memberCount; j++) {
                String memberName = br.readLine();
                map.get(groupName).add(memberName);
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < question; i++) {
            String name = br.readLine();
            String questionType = br.readLine();
            if (questionType.equals("0")) {
                list.addAll(
                        map.get(name)
                                .stream()
                                .sorted()
                                .collect(Collectors.toList())
                );
            } else {
                list.addAll(
                        map.entrySet()
                                .stream()
                                .filter(entry -> entry.getValue().contains(name))
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toList())
                );
            }
        }
        System.out.println(
                String.join("\n", list)
        );
    }
}
