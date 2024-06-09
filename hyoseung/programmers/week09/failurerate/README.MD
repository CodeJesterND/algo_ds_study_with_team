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