# 두 개 뽑아서 더하기 
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/68644)

```
import java.util.*;

class Solution {
    public List<Integer> solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        boolean []flag = new boolean[200];
        for(int i=0; i< numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                int num = numbers[i] + numbers[j];
                if(!flag[num]) {
                    list.add(num);    
                    flag[num] = true;
                }
                
            }
        }
        Collections.sort(list);   
        return list;
    }
}
```