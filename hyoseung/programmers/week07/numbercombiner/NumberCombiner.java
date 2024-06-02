package programmers.week06.numbercombiner;

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (!list.contains(sum)) {
                    list.add(sum);
                }
            }
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).sorted().toArray();

        return answer;
    }
}

public class NumberCombiner {
    public static void main(String[] args) {
        Solution so = new Solution();

        int[] numbers = {2, 1, 3, 4, 1};
        int[] result = so.solution(numbers);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}