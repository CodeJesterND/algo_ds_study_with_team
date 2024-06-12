# 모의고사 
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/42840)

## 문제 풀이 
1. 각각의 answer[0], answer[1], answer[2] 각각 i%num1.length를 통해서 각각에 해당하는 부분을 만들어주었다.
2. 최고의 값을 for문을 통해서 저장해 준 후에, list를 통해서 각각 구해 준다.
3. result[i]에 해당 하는 부분이 차례대로 들어 올 것 이기 때문에 해당 부분을 정렬하지 않아도 정상적으로 동작한다. 
```
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int []num1 = {1, 2, 3, 4, 5};
        int []num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int []num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
             
        for(int i=0; i< answers.length; i++){
            if(answers[i] == num1[i%num1.length]) answer[0]++;
            
            if(answers[i] == num2[i%num2.length]) answer[1]++;
            
            if(answers[i] == num3[i%num3.length]) answer[2]++;
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int n : answer) max = Math.max(max , n);
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<answer.length; i++) if(answer[i] == max) list.add(i+1);  
        
        int []result = new int[list.size()];
        
        for(int i=0;i<list.size(); i++) result[i] = list.get(i); 
        
        return result;
    }
}
```