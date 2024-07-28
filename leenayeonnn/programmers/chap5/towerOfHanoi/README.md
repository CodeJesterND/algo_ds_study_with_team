[프로그래머스 - 하노이의 탑](https://school.programmers.co.kr/learn/courses/30/lessons/12946)

---

### 내 풀이
```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] solution(int n) {
        List<int[]> answer = new ArrayList<>();
        hanoi(n, 1, 3, answer);
        return answer.toArray(new int[0][]);
    }
    
    private static void hanoi(int n, int from, int to, List<int[]> answer) {
        if (n == 1) {
            answer.add(new int[]{from, to});
            return;
        }

        int mid = 6 - from - to;

        hanoi(n - 1, from, mid, answer);
        hanoi(1, from, to, answer);
        hanoi(n - 1, mid, to, answer);
    }
}
```

<br/>

---

### 교재 풀이

동일
