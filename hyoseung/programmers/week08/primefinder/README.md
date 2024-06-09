## 소수 찾기

```java
import java.util.Arrays;

class Solution {
    public int solution(int n) {
        boolean[] Eratos = new boolean[n + 1]; 
        
        Arrays.fill(Eratos, true); 
        for (int i = 2; i * i <= n; i++) { 
            if (Eratos[i]) 
                for (int j = i * i; j <= n; j += i) 
                    Eratos[j] = false;
        }
 
        int answer = 0;
        for (int i = 2; i <= n; i++) 
            if (Eratos[i])
                answer++;
 
        return answer; 
    }
}
```

* 주어진 수 n 이하의 모든 수에 대한 소수 여부를 저장할 boolean 배열을 생성한다.
* 배열을 모두 `true`로 초기화한다.
* 2부터 시작하여 제곱이 n 이하인 수까지 반복하면서 소수 여부를 판별한다.
* 해당 수가 소수일 경우, 그 배수들을 모두 소수가 아닌 것으로 표시한다.
* 소수로 남아 있는 수들의 개수를 세고 반환한다.