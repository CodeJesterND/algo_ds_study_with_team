## 실패율

```java
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N]; 
        int totalUsers = stages.length;
        
        Map<Integer, Double> failRateOnStages = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            int usersOnStage = 0;
            for (int stage : stages) {
                if (stage == i) {
                    usersOnStage++;
                }
            }
            
            double failRate = 0; 
            if (totalUsers != 0) {
                failRate = (double) usersOnStage / totalUsers; 
            }
            
            failRateOnStages.put(i, failRate);
            totalUsers -= usersOnStage;
        }
        
        
        List<Map.Entry<Integer, Double>> sortedStages = new ArrayList<>(failRateOnStages.entrySet());
        sortedStages.sort((obj1, obj2) -> {
            if (obj1.getValue() > obj2.getValue()) {
                return -1;
            } else if (obj1.getValue() < obj2.getValue()) {
                return 1;
            } else {
                return obj1.getKey() - obj1.getKey(); 
            }
        });
        
        int index = 0;
        for (Map.Entry<Integer, Double> entry : sortedStages) {
            answer[index++] = entry.getKey();
        }
        
        return answer;
    }
}
```

* 각 스테이지별 실패율을 계산하여 `failRateOnStages` 맵에 저장한다.
* 실패율을 계산할 때는 해당 스테이지에 머물러 있는 사용자 수를 전체 사용자 수로 나눈다.
* 실패율을 기준으로 `sortedStages` 리스트에 정렬하여 저장한다.
* 정렬된 스테이지를 순회하면서 각 스테이지 번호를 `answer` 배열에 저장한다.
* `answer` 배열을 반환한다.