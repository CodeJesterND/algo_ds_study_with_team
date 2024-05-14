package programmers.week06.closestsamecharfinder;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> charIndex = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charIndex.containsKey(c)) {
                result.add(-1);
            } else {
                result.add(i - charIndex.get(c));
            }

            charIndex.put(c, i);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

public class ClosestSameCharFinder {
    public static void main(String[] args) {
        Solution so = new Solution();

        System.out.println(Arrays.toString(so.solution("banana")));
        System.out.println(Arrays.toString(so.solution("foobar")));
    }
}