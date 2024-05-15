# 가장 가까운 같은 글자 

## [link](https://school.programmers.co.kr/learn/courses/30/lessons/142086)

## 문제풀이
```
class Solution {
    public int[] solution(String s) {
        int []answer = new int[s.length()];
        
        boolean []firstFlag = new boolean[26];
        int []alpha = new int[26];
        
        for(int i=0;i<s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(!firstFlag[index]) {
                answer[i] = -1;
                firstFlag[index] = true;
                alpha[index] = i;
            } else {
               answer[i] = i - alpha[index];
               alpha[index] = i; 
            }
        }
        
        return answer;
    }
}
```