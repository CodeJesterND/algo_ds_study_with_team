package programmers.week07.foodfightcompetition;

public class FoodFightCompetition {
    public static void main(String[] args) {
        int[] food1 = {1, 3, 4, 6};
        int[] food2 = {1, 3, 4, 6};

        Solution so = new Solution();

        String result1 = so.solution(food1);
        System.out.println("Result: " + result1);

        String result2 = so.solution(food2);
        System.out.println("Result: " + result2);
    }
}

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int twoCount = food[i] / 2;
            for(int j = 0; j < twoCount; j++) {
                sb.append(i);
            }
        }

        String leftStr = sb.toString();
        String rightStr = sb.reverse().toString();

        String answer = leftStr + "0" + rightStr;

        return answer;
    }
}