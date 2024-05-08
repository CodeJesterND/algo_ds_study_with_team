package programmers.week05.gcdandlcm;

import java.util.Arrays;

class Solution {
    public int[] solution(int n, int m) {
        int gcdResult = gcd(n, m);
        int lcmResult = n * m / gcdResult;
        return new int[] {gcdResult, lcmResult};
    }

    public int gcd(int a, int b) {
        int r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}

public class GCDAndLCM {
    public static void main(String[] args) {
        Solution so = new Solution();

        System.out.println(Arrays.toString(so.solution(3, 12)));
        System.out.println(Arrays.toString(so.solution(2, 5)));
    }
}