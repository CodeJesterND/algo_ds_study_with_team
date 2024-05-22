package programmers.week07.cola;

public class cola {
    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        int n = 20;

        int c = 3;
        int d = 2;
        int r = 20;

        Solution solution = new Solution();

        int totalCola1 = solution.solution(a, b, n);
        System.out.println("Total Cola Bottles: " + totalCola1);

        int totalCola2 = solution.solution(c, d, r);
        System.out.println("Total Cola Bottles: " + totalCola2);
    }
}

class Solution {
    public int solution(int a, int b, int n) {
        if(n < a) {
            return 0;
        }

        int totalCola = 0;

        while(n >= a) {
            int newCola = (n / a) * b;
            totalCola += newCola;
            n = (n % a) + newCola;
        }

        return totalCola;
    }
}