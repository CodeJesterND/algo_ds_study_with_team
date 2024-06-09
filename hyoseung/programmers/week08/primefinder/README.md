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