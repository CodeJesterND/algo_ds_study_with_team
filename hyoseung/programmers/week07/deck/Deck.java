package programmers.week07.deck;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;

        for (String word : goal) {
            if (idx1 < cards1.length && word.equals(cards1[idx1])) {
                idx1++;
            } else if (idx2 < cards2.length && word.equals(cards2[idx2])) {
                idx2++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}


public class Deck {
    public static void main(String[] args) {

        Solution sol = new Solution();

        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println(sol.solution(cards1, cards2, goal)); // "Yes"
    }
}