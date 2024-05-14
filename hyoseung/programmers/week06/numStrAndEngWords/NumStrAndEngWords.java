package programmers.week06.numStrAndEngWords;

class Solution {
    public int solution(String s) {
        String[] arr = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i = 0; i < arr.length; i++) {
            if(s.contains(arr[i])) {
                s = s.replace(arr[i], Integer.toString(i));
            }
        }

        return Integer.parseInt(s);
    }
}

public class NumStrAndEngWords {
    public static void main(String[] args) {
        Solution so = new Solution();

        System.out.println(so.solution("one4seveneight"));
        System.out.println(so.solution("23four5six7"));
        System.out.println(so.solution("2three45sixseven"));
        System.out.println(so.solution("123"));
    }
}