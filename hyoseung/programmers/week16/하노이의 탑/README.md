## 하노이의 탑

<br/>

### 책 참조 전 상태의 코드
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<int[]> arr = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);

        int[][] answer = new int[arr.size()][2];
        for(int i=0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }

        return answer;
    }

    public void hanoi(int n, int start, int end, int mid) {
        if(n == 1) { // 원판이 1개일 경우
            arr.add(new int[]{start, end});
        } else {
            hanoi(n-1, start, mid, end);
            arr.add(new int[]{start, end}); // 가장 큰 원판을 이동
            hanoi(n-1, mid, end, start); // 나머지 n-1개의 원판을 이동
        }
    }
}
```

### 책 참조 후 상태의 코드
```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private void hanoi(int n, int from, int to, List<int[]> process) {
        if (n == 1) {
            process.add(new int[] {from, to});
            return;
        }

        int empty = 6 - from - to;

        hanoi(n-1, from, empty, process);
        hanoi(1, from, to, process);
        hanoi(n-1, empty, to, process);
    }

    public int[][] solution(int n) {
        List<int[]> process = new ArrayList<>();
        hanoi(n, 1, 3, process);
        return process.toArray(new int[0][]);
    }
}
```