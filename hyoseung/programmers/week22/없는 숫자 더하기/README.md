## 없는 숫자 더하기

<br/>

### 책 참조 전 상태의 코드
```java
public class Solution {
    public int solution(int[] numbers) {
        int total = 0;
        for (int i = 0; i <= 9; i++) {
            total += i;
        }
        
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        
        return total - sum;
    }
}
```

<br/>

### 책 참조 후 상태의 코드
```java
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int[] numbers) {
        Set<Integer> set = new HashSet<>(Integer);
        for (int v : numbers) {
            set.add(v);
        }
        
        int sum = 0;
        for (int n = 0; n <= 9; n++) {
            if (set.contains(n)) continue;
            sum += n;
        }
        
        return sum;
    }
}
```