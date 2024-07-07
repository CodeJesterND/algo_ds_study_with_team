## 과일 장수

```java
import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        for (int i = score.length; i >= m; i -= m) {
            answer += score[i - m] * m; 
        }
        
        return answer;
    }
}
```

* 과일 가격 배열을 오름차순으로 정렬한다.
* 판매한 과일의 개수를 기준으로 하여 최대 m개씩 묶어서 해당 그룹의 최소값을 m번 곱하여 더한다.
* 이러한 과정을 반복하여 얻은 총 수익을 반환한다.