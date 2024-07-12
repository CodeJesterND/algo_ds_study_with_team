## [link](https://school.programmers.co.kr/learn/courses/30/lessons/258712)

## 가장 많이 받은 선물 - 문제 풀이


```
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, HashMap<String,Integer>> records = new HashMap<>();
        Map<String, Integer> scores = new HashMap<>();
        Map<String, Integer> nextMonth = new HashMap<>();
        for(int i=0;i<friends.length; i++){
            records.put(friends[i], new HashMap<>());
            scores.put(friends[i], 0);
            nextMonth.put(friends[i],0);
        }
        
        for(int i=0;i<gifts.length; i++){
            String []gift = gifts[i].split(" ");
            records.get(gift[0]).put(gift[1],records.get(gift[0]).getOrDefault(gift[1],0) + 1);
            scores.put(gift[0], scores.getOrDefault(gift[0],0)+1);
            scores.put(gift[1], scores.getOrDefault(gift[1],0)-1);
        }
        
        for(String giver : friends){
            for(String receiver : friends) {
                int giverCount = records.get(giver).getOrDefault(receiver, 0);                 
                int receiverCount = records.get(receiver).getOrDefault(giver, 0);
                if(giverCount > receiverCount) {
                    nextMonth.put(giver, nextMonth.getOrDefault(giver, 0)+1);
                } else if(giverCount == receiverCount && scores.get(giver) > scores.get(receiver)){
                    nextMonth.put(giver, nextMonth.getOrDefault(giver, 0)+1);
                }
            }
        }
        
        
        
        return Collections.max(nextMonth.values());
    }
                          
}
```
![img.png](img.png)
1. 실질적인 선물 기록을 담아 줄 record map을 선언해주었다.
2. score, nextMonth 에 해당하는 부분 각각을 map을 선언해주었다.
3. friends.length를 돌면서 각각 map에 대한 세팅을 해주었다.
4. gitft를 split으로 String 배열로 나누어주어 선물을 보낸 사람 목록에 받은 사람을 추가시켜준다.
5. 이 때, score에 각각 해당 하는 선물 지수를 나타내기 위해 더하고 뺴준다.
6. 이중 포문을 돌면서 모든 경우의 수를 비교해주며 이 떄, record.get(giver).getOrDefault를 통하여 주는 사람 받는 사람에 대한 주고 받은 정보를 받아와 주었다.
7. giverCount 가 receiverCount보다 크다면 nextMonth에 다가 정상적으로 넣어주고 그게 아니라면 giverCount == receiverCount가 같지만 giver가 scores.get보다 큰 경우에만 nextMonth.put에 넣어주었다. 

