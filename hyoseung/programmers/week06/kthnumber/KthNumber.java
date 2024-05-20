package programmers.week06.kthnumber;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int start = command[0];
            int end = command[1];
            int k = command[2];

            int[] slicedArr = Arrays.copyOfRange(array, start - 1, end);

            Arrays.sort(slicedArr);

            answer[i] = slicedArr[k - 1];
        }

        return answer;
    }
}


public class KthNumber {
    public static void main(String[] args) {
        Solution so = new Solution();

        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        int[] result = so.solution(arr, commands);

        System.out.println(Arrays.toString(result));
    }
}