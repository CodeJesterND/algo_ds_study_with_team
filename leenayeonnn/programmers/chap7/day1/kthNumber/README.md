[프로그래머스 - K번째수](https://school.programmers.co.kr/learn/courses/30/lessons/42748)

---

### 내 풀이
```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] arrayPart = Arrays.stream(array, commands[i][0] - 1, commands[i][1]).sorted().toArray();
            result[i] = arrayPart[commands[i][2] - 1];
        }
        return result;
    }
}
```

<br/>

---

### 교재 풀이

```java
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < answer.length; i++) {
            int[] command = commands[i];
            int from = command[0] - 1;  // 0-base
            int to = command[1];        // exclusive
            int k = command[2] - 1;     // 0-base

            int[] sub = Arrays.copyOfRange(array, from, to);
            Arrays.sort(sub);
            answer[i] = sub[k];
        }

        return answer;
    }
}
```

