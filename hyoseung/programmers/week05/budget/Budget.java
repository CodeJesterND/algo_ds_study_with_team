package programmers.week05.budget;

import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0; // 최대 몇 개의 부서에 물품을 지원할 수 있는지

        for (int i = 0; i < d.length; i++) {
            if (budget - d[i] >= 0) {
                budget -= d[i];
                count ++; // 지원한 부서 수 증가
            } else {
                break; // 음수가 될 경우 더 이상 지원할 수 없음
            }
        }
        return count;
    }
}

public class Budget {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] d = {1, 3, 2, 5, 4};
        int budget = 9;

        System.out.println(so.solution(d, budget));
    }
}