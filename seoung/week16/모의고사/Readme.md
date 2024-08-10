## [Link](https://school.programmers.co.kr/learn/courses/30/lessons/42840)
## 모의고사


## 내가 푼 풀이
```
import java.util.*;

class Solution {
    public Integer[] solution(int[] answers) {
        int []answer1 = {1, 2, 3, 4, 5};
        int []answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int []answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        
        int []count = new int[3];
        for(int i=0; i<answers.length; i++) {
            if(answers[i]==answer1[i%answer1.length]) {
                count[0]++;
            } 
            if(answers[i]==answer2[i%answer2.length]) {
                count[1]++;
            }
            if(answers[i]==answer3[i%answer3.length]){
                count[2]++;
            }
        }
        
        int max = 0;
        
        for(int n : count) max = Math.max(max,n);
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<count.length; i++)  if(count[i]==max) list.add(i+1);
        
        
        return list.toArray(Integer[]::new);
    }
}
```


## 책 풀이
```
import java.util.*;
import java.util.stream.IntStream;

class Solution {
    private static final int[][] RULES = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    
    
    private int getPicked(int person, int problem) {
        int[] rule = RULES[person];
        int index = problem % rule.length;
        return rule[index];
    }
    
    public int[] solution(int[] answers) {
       int[] corrects = new int[3];
       int max = 0;
        
       for(int problem = 0; problem < answers.length; problem++) {
           int answer = answers[problem]; // 실제 정답
           
           for(int person = 0; person < 3; person++) {
               int picked = getPicked(person, problem); // 내가 찍은 번호 가져오는 부분
               if(answer == picked) {
                   if(++corrects[person] > max) { // 해당 로직을 비교하며 증가
                       max = corrects[person]; // max = corrects[person] 을 통해서 max에 대입
                   }
               }
           }
       }
        
       final int maxCorrects = max;
        return IntStream.range(0, 3)
                    .filter(i -> corrects[i] == maxCorrects)
                    .map(i -> i + 1)
                    .toArray();
        
    }
}
```
