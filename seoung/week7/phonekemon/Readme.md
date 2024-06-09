## 폰켓몬
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/1845)

```
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        Arrays.stream(nums).forEach(num-> set.add(num));
        if(set.size()> nums.length/2) return nums.length/2;
        
            
        
        return set.size();
    }
}
```
1. HashSet을 통하여 중복된 값들을 제거하며 들어와준다. 
2. 해당 문제는 글을 이해하는데 어려움을 겪었음.. 바보
