# 체육복 
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/42862)

## 문제풀이 
1. map을 통해 점수를 담을 자료형을 선언주었다.
2. 초기 세팅값을 1로 설정해주었다.
3. 앞 부터 먼저 뺴주는 구문 if를 넣어주고 아니라면 뒤에부터 순서가 중요함

```
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=1; i<=n; i++){
            map.put(i, 1);
        }
        
        for(int i=0; i<lost.length; i++){
            map.put(lost[i], map.get(lost[i])-1);
        }
        
        for(int i=0; i<reserve.length; i++){
            map.put(reserve[i], map.get(reserve[i])+1);
        }
        
        for(int i=1; i<=n; i++){
            if(map.get(i)<=0){
                if(i-1>0 && map.get(i-1)>=2){
                    map.put(i-1, map.get(i-1)-1);
                    map.put(i, map.get(i)+1);
                } else if(i<n && map.get(i+1) >= 2){
                    map.put(i+1, map.get(i+1)-1);
                    map.put(i, map.get(i)+1);
                } 
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()>=1) {
                answer++;
            }
        }
        
        return answer;
    }
}
```