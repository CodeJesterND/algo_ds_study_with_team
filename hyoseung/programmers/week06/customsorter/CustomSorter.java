package programmers.week06.customsorter;

import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            char c1 = s1.charAt(n);
            char c2 = s2.charAt(n);

            if (c1 == c2) {
                return s1.compareTo(s2);
            } else {
                return Character.compare(c1, c2);
            }
        });
        return strings;
    }
}

public class CustomSorter {

}
