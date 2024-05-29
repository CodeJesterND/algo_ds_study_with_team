package programmers.week07.memoriesscore;

import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> yearningMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            yearningMap.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];

        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (String person : photo[i]) {
                if (yearningMap.containsKey(person)) {
                    score += yearningMap.get(person);
                }
            }
            answer[i] = score;
        }

        return answer;
    }
}

public class MemoriesScore {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] name = {"may", "kein", "kain", "kali", "mari", "don"};
        int[] yearning = {5, 10, 1, 11, 1, 55};
        String[][] photo = {
                {"may", "kein", "kain"},
                {"kali", "mari", "don", "tony"},
                {"may", "don"}
        };

        int[] result = sol.solution(name, yearning, photo);
        System.out.println(Arrays.toString(result)); // [16, 67, 60]
    }
}