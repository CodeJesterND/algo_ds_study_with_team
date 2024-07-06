# [link](https://school.programmers.co.kr/learn/courses/30/lessons/133502)

## 문제 풀이 
```
import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        
        for(int i : ingredient) {
            s.add(i); 
            
            int n = s.size();
            if(n> 3) {
                if(s.get(n - 1) == 1 && s.get(n -2) == 3 && s.get(n-3) == 2 && s.get(n-4) == 1){
                    answer ++;
                    s.pop();
                    s.pop();
                    s.pop();
                    s.pop();
                }
            }
            
        }
        
        return answer;
    }
}
```
## Key - Point:  빵 – 야채 – 고기 - 빵 순으로 쌓인다. 
## 1 빵 , 2 야채 , 3 고기를 의미한다.
1. Stack을 선언 해주었다. 
2. Stack에서 size가 3보다 크다면 각각을 비교해준다. 
3. n에서 n-1은 빵 n-2 고기 순이기 때문에  if문을 위에 같은 형태로 걸어줌
4. 이 때, answer를 증가 시켜주었다.
5. 각각을 stack에서 pop으로 뺴주었다. 