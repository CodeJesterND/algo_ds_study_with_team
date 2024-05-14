package programmers.week06.smallerSubString;

class Solution {
    public int solution(String t, String p) {
        int count = 0;

        for(int i = 0; i <= t.length() - p.length(); i++) {
            if (Long.parseLong(t.substring(i, i + p.length())) <= Long.parseLong(p)) {
                count++;
            }
        }
        return count;
    }
}

public class smallerSubString {
    public static void main(String[] args) {
        Solution so = new Solution();

        System.out.println(so.solution("3141592", "271"));
        System.out.println(so.solution("500220839878", "7"));
        System.out.println(so.solution("10203", "15"));
    }
}