# K번째수


```
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0;i<commands.length;i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int targetNum = commands[i][2];
            int []clone = Arrays.copyOfRange(array, start-1, end);
            
            Arrays.sort(clone);
            answer[i] = clone[targetNum-1];
        }
        
        return answer;
    }
}
```