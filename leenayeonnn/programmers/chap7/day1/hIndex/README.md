[프로그래머스 - H-Index](https://school.programmers.co.kr/learn/courses/30/lessons/42747)

---

### 내 풀이
```java
import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int h = citations.length; h > 0; h--) {
            int idx = citations.length - h;
            if(citations[idx] >= h) {
                return h;
            }
        }
        return 0;
    }
}
```

<br/>

---

### 교재 풀이

```java
import java.util.Arrays;

public class Solution {
    private boolean isValid(int[] citations, int h) {
        int index = citations.length - h;
        return citations[index] >= h;
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        for (int h = citations.length; h >= 1; h--) {
            if (isValid(citations, h)) return h;
        }
        return 0;
    }
}
```

