package programmers.week06.caesarpassword;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(Character.isLowerCase(c)) {
                sb.append((char)('a' + (c - 'a' + n) % 26));
            }
            else if(Character.isUpperCase(c)) {
                sb.append((char)('A' + (c - 'A' + n) % 26));
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

public class caesarPassword {
    public static void main(String[] args) {
        Solution so = new Solution();

        System.out.println(so.solution("AB", 1));
        System.out.println(so.solution("z", 1));
        System.out.println(so.solution("a B z", 1));
    }
}