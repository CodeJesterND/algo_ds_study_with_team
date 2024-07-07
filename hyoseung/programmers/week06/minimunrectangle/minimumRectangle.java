package programmers.week06.minimunrectangle;

import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        for(int i = 0; i < sizes.length; i++) {
            Arrays.sort(sizes[i]);
        }

        int maxW = 0;
        int maxH = 0;

        for(int i = 0; i < sizes.length; i++) {
            if(maxW < sizes[i][0]) {
                maxW = sizes[i][0];
            }

            if(maxH < sizes[i][1]) {
                maxH = sizes[i][1];
            }
        }

        return maxW * maxH;
    }
}

public class minimumRectangle {
    public static void main(String[] args) {
        int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

        Solution so = new Solution();

        System.out.println(so.solution(sizes1));
        System.out.println(so.solution(sizes2));
        System.out.println(so.solution(sizes3));
    }
}