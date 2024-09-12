[프로그래머스 - 두 개 뽑아서 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/68644)

---

### 내 풀이
```java
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] result = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(result);
        return result;
    }
}
```

<br/>

---

### 교재 풀이

동일

