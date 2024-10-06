## 평행

<br/>

### 책 참조 전 상태의 코드
```java

```

<br/>

### 책 참조 후 상태의 코드
```java
import java.util.Arrays;

public class Solution {
    private boolean isValid(int d, int[] rocks, int n) {
        int removed = 0;  // 제거한 바위 개수
        int last = 0;     // 마지막 바위 위치
        for (int rock : rocks) {
            if (rock - last < d) {
                removed++;
                continue;
            }
            last = rock;
        }
        return removed <= n;
    }

    public int solution(int distance, int[] rocks, int n) {
        rocks = Arrays.copyOf(rocks, rocks.length + 1);
        rocks[rocks.length - 1] = distance;
        Arrays.sort(rocks);

        int start = 1;
        int end = distance + 1;

        while (end - start > 1) {
            int d = (start + end) / 2;
            if (isValid(d, rocks, n)) {
                start = d;
            } else {
                end = d;
            }
        }

        return start;
    }
}
```