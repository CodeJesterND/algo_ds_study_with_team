## 입국심사

<br/>

### 책 참조 전 상태의 코드
```java
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long total = 0;

            for (int time : times) {
                total += mid / time;
                if (total >= n) break;
            }

            if (total >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
```

<br/>

### 책 참조 후 상태의 코드
```java
public class Solution {
    private boolean isValid(long t, int n, int[] times) {
        long c = 0;
        for (int time : times) {
            c += t / time;
        }
        return c >= n;
    }

    public long solution(int n, int[] times) {
        long start = 1;
        long end = 10000000000000000L;

        while (end > start) {
            long t = (start + end) / 2;
            if (isValid(t, n, times)) {
                end = t;
            } else {
                start = t + 1;
            }
        }

        return start;
    }
}
```