package programmers.week05.trio;

class Solution {
    public int solution(int[] number) { // Bruteforce 참고
        int count = 0;
        int n = number.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

public class Trio {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[][] numbers = {
                {-2, 3, 0, 2, -5},
                {-3, -2, -1, 0, 1, 2, 3},
                {-1, 1, -1, 1}
        };

        for (int[] nums : numbers) {
            System.out.println(so.solution(nums));
        }
    }
}