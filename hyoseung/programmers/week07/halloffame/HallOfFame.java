package programmers.week07.halloffame;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(int k, int[] score) {
        Queue<Integer> hallOfFame = new PriorityQueue<>();

        int[] dailyMinScores = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            int currentScore = score[i];
            if (hallOfFame.size() < k) {
                hallOfFame.add(currentScore);
            }

            else if (currentScore > hallOfFame.peek()) {
                hallOfFame.poll();
                hallOfFame.add(currentScore);
            }

            dailyMinScores[i] = hallOfFame.peek();
        }

        return dailyMinScores;
    }
}

public class HallOfFame {
    public static void main(String[] args) {
        Solution so = new Solution();

        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};

        int[] result = so.solution(k, score);

        System.out.println(Arrays.toString(result));
    }
}