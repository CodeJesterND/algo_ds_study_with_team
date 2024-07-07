## [link](https://school.programmers.co.kr/learn/courses/30/lessons/178871)

## 달리기 경우 - 문제 풀이


```
import java.util.*;
class Solution {
    public ArrayList<String> solution(String[] players, String[] callings) {
     
        // players.length
        Map<String, Integer> playerMap = new HashMap<>();
        Map<Integer, String> rankMap = new HashMap<>();
        for(int i=0;i<players.length; i++){
            playerMap.put(players[i], i+1);
            rankMap.put(i+1, players[i]);
        }
        
        for(int i=0; i<callings.length; i++){
            int ranking = playerMap.get(callings[i]);
            String call = rankMap.get(ranking);
            String previousCall = rankMap.get(ranking-1);
            playerMap.put(callings[i], ranking-1);
            rankMap.put(ranking-1, callings[i]);
            playerMap.put(previousCall, ranking);
            rankMap.put(ranking, previousCall);
        }
        
        ArrayList<String> list = new ArrayList<>(rankMap.values());
        return list;
    }
}
```

1. playMap에 플레이 이름과 스코어를 저장할 배열을 만든다.
2. rankMap에는 순위오 이름을 저장한다.
3. 반복문을 통해서 해당 부분을 불릴 때 마다 ma위치를 한칸 씩 변경 한다.
