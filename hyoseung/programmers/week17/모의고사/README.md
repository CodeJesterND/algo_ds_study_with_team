## 모의고사

<br/>

### 책 참조 전 상태의 코드
```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[] supo1 = {1, 2, 3, 4, 5};
        int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == supo1[i % supo1.length]) {
                scores[0]++;
            }
            if (answers[i] == supo2[i % supo2.length]) {
                scores[1]++;;
            }
            if (answers[i] == supo3[i % supo3.length]) {
                scores[2]++;
            }
        }
        
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        int count = (int) Arrays.stream(scores).filter(score -> score == maxScore).count();
        
        int[] bestSupo = new int[count];
        int index = 0;
        for (int j = 0; j < scores.length; j++) {
            if (scores[j] == maxScore) {
                bestSupo[index++] = j + 1;
            }
        }
        
        return bestSupo;
    }
}
```

### 책 참조 후 상태의 코드
```java
import java.util.*;
import java.util.stream.IntStream;

class Solution {
    private static final int[][] RULES = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };


    private int getPicked(int person, int problem) {
        int[] rule = RULES[person];
        int index = problem % rule.length;
        return rule[index];
    }

    public int[] solution(int[] answers) {
        int[] corrects = new int[3];
        int max = 0;

        for(int problem = 0; problem < answers.length; problem++) {
            int answer = answers[problem]; // 실제 정답

            for(int person = 0; person < 3; person++) {
                int picked = getPicked(person, problem); // 내가 찍은 번호 가져오는 부분
                if(answer == picked) {
                    if(++corrects[person] > max) { // 해당 로직을 비교하며 증가
                        max = corrects[person]; // max = corrects[person] 을 통해서 max에 대입
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