## 명예의 전당
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/138477)

```
import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        
        int[] answer = new int[score.length];
        
        Queue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<score.length; i++){
            if(q.size() < k){
                q.add(score[i]);
                answer[i] = q.peek();
            } else {
                if(q.peek() < score[i]) {
                    q.poll();
                    q.add(score[i]);
                    answer[i] = q.peek();
                } else if(q.peek() >= score[i]){
                    answer[i] = q.peek();
                }
            }
            
        }
        
        return answer;
    }
}
```
1. priorityQueue를 사용해서 가져올 수 있다.
