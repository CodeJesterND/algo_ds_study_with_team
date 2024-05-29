package programmers.week07.pokemon;

import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> uniquePokemon = new HashSet<>();

        for (int num : nums) {
            uniquePokemon.add(num);
        }

        int uniqueCount = uniquePokemon.size();

        int maxPokemonToTake = nums.length / 2;

        int answer = (uniqueCount < maxPokemonToTake) ? uniqueCount : maxPokemonToTake;

        return answer;
    }
}

public class Pokemon {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // 예시 입력
        int[] nums1 = {3, 1, 2, 3};
        System.out.println(sol.solution(nums1)); // 출력: 2

        int[] nums2 = {3, 3, 3, 2, 2, 4};
        System.out.println(sol.solution(nums2)); // 출력: 3
    }
}