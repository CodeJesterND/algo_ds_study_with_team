package programmers.week05.ternaryreverse;

class Solution {
    public int solution(int n) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            int remainder = n % 3; // 나머지 값을 진법 변환 값으로 활용
            result.insert(0, remainder); // 나머지를 문자열 앞에 삽입
            n /= 3; // 진법 공식은 몫이 0일 때까지 계속 나눔
        }

        result.reverse(); // 결과 뒤집기

        int answer = Integer.parseInt(result.toString(), 3);

        return answer;
    }
}

public class TernaryReverse {
    public static void main(String[] args) {
        Solution so = new Solution();

        System.out.println(so.solution(45));
        System.out.println(so.solution(125));
    }
}