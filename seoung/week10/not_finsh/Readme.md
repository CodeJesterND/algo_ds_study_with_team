# 완주하지 못한 선수 
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/42576)

## 문제 풀이
1. map을 통해서 완료를 저장해 줄 자료형을 선언 해주었다.
2. for문 구문에서 map에 포함되어 있지않으면 put으로 넣어주며 아니라면 replace를 통해 map.get(c)+1을 해주어 replace 를 통해서 바꾸어준다. 
3. containsKey(p)가 포함되어 있을 경우 0이 아니면 -1을 해주고 만약 0이 아니고, containsKey포함되어 있다면 break를 뱉으면서 answer 값을 구해준다.

```
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
       Map<String, Integer> map = new HashMap<>();
        
       for(String c : completion){
           if(!map.containsKey(c)){
               map.put(c, 1);
           } else {
               map.replace(c, map.get(c)+1);
           }
       }
          
        for(String p: participant){
            if(map.containsKey(p) && map.get(p)!=0){
                map.replace(p, map.get(p)-1);
            } else {
                answer = p;
                break;
            }
        }
        
        return answer;
    }
}
```