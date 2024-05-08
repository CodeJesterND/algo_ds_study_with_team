package programmers.week05.createstrangecharacters;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] words = s.split(" ", -1); // 공백을 기준으로 문자열을 분할

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (j % 2 == 0) { // 짝수번째 문자인 경우
                    answer.append(Character.toUpperCase(ch)); // 대문자로 변환
                } else {
                    answer.append(Character.toLowerCase(ch)); // 소문자로 변환
                }
            }
            if (i != words.length - 1) { // 마지막 단어가 아닌 경우에만 공백 추가
                answer.append(" ");
            }
        }
        return answer.toString();
    }
}

public class CreateStrangeCharacters {
    public static void main(String[] args) {
        Solution so = new Solution();

        String result = so.solution("   AA   aa   ZZ   zz   ");
        System.out.println("[" + result + "]");
    }
}