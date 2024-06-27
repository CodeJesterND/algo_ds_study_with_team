## 달리기 경주

```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {  
        Map<String, Integer> playersRank = new HashMap<>(); 
        
        for (int i = 0; i < players.length; i++) { // 선수들의 이름과 순위 저장...!
            playersRank.put(players[i], i);
        }
        
        for (String player : callings) { 
            int currentRank = playersRank.get(player); // 현재 호출된 선수의 순위 저장
            
            String frontPlayer = players[currentRank - 1]; // 현재 순위를 기준으로 앞사람 선수 소환
            
            playersRank.replace(frontPlayer, currentRank); // 앞 사람 선수의 순위 조정
            players[currentRank] = frontPlayer; // 현재 순위에 앞 선수를 저장
            
            playersRank.replace(player, currentRank -1); // 호출된 선수의 순위 조정
            players[currentRank - 1] = player; // 호출된 선수의 순위를 저장
        }
        
        return players;
    }
}
```

* `playersRank` 라는 `HashMap` 을 생성하여 각 선수의 이름과 현재 순위를 저장한다.
* `players` 배열을 순회하면서 각 선수의 이름과 그 선수의 인덱스를 `playersRank` 맵에 저장한다.
* `callings` 배열을 순회하면서 각 호출된 선수의 현재 순위를 가져온다
* 호출된 선수의 현재 순위를 기준으로 앞에 있는 선수의 이름을 가져온다.
* 앞 선수와 호출된 선수의 순위를 서로 교환한다.
* `players` 배열과 `playersRank` 맵을 업데이트하여 순위를 조정한다.