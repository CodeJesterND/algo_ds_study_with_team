[프로그래머스 - 모의고사](https://school.programmers.co.kr/learn/courses/30/lessons/42840)

---

### 내 풀이
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    // 각 학생의 찍기 방법 설정
    private static final int[][] METHOD = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    
    public int[] solution(int[] answers) {

        int[] scores = new int[3];

        // 모든 답을 돌면서
        for (int i = 0; i < answers.length; i++) {

            // 각 방식의
            for (int m = 0; m < 3; m++) {

                // 해당 번호의 답이 일치하면
                int checkNum = METHOD[m][i % METHOD[m].length];
                if (checkNum == answers[i]) {

                    // 점수 증가
                    scores[m]++;
                }
            }
        }
        
        // max 값을 찾아서 해당 학생의 번호를 list에 넣기
        List<Integer> answer = new ArrayList<>();
        answer.add(1);

        int max = scores[0];
        for (int i = 1; i < 3; i++) {
            if (scores[i] > max) {
                answer.clear();
                answer.add(i + 1);
                max = scores[i];
            } else if (scores[i] == max) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
```

<br/>

---

### 교재 풀이

```java
import java.util.stream.IntStream;

public class Solution {
    private static final int[][] RULES = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5},
    };

    private int getPicked(int person, int problem) {
        int[] rule = RULES[person];
        int index = problem % rule.length;
        return rule[index];
    }

    public int[] solution(int[] answers) {
        int[] corrects = new int[3];
        int max = 0;

        for (int problem = 0; problem < answers.length; problem++) {
            int answer = answers[problem];

            for (int person = 0; person < 3; person++) {
                int picked = getPicked(person, problem);
                if (answer == picked) {
                    if (++corrects[person] > max) {
                        max = corrects[person];
                    }
                }
            }
        }

        final int maxCorrects = max;
        return IntStream.range(0, 3)
                .filter(i -> corrects[i] == maxCorrects)
                .map(i -> i + 1)
                .toArray();
    }
}
```

