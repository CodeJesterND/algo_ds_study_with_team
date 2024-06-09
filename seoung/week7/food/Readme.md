## 푸드 파이터
## [link](hhttps://school.programmers.co.kr/learn/courses/30/lessons/134240)
```
import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<food.length; i++){
            for(int j=0; j < food[i]/2; j++) {
                sb.append(i);
            }
        }
        
        answer = sb.toString() + "0" + sb.reverse();
        
        return answer;
    }
}
```

1. food에서 출력되는 절반만 가져온다. 
2. 해당 값을 StringBuilder에 넣어준다. 
3. answer 위치에서 0을 더해주고 reverse()함수를 통해서 문자열을 뒤집어 구해준다. 
