## 성격 유형 검사하기

```java
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        char[] mbtiType = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'}; // MBTI 유형 배열
        Map<Character, Integer> mbtiScores = new HashMap<>(); // 각 MBTI 유형 점수 저장

        for (char c : mbtiType) { // 모든 MBTI 유형 점수 초기화
            mbtiScores.put(c, 0);
        }

        for (int i = 0; i < survey.length; i++) { // 각 설문 결과를 반영하여 MBTI 점수를 업데이트
            if (choices[i] > 4) { // 동의 유형의 따른 점수 증가
                mbtiScores.put(survey[i].charAt(1), mbtiScores.get(survey[i].charAt(1)) + (choices[i] - 4));
            } else if (choices[i] < 4) { // 미동의 유형의 따른 점수 증가
                mbtiScores.put(survey[i].charAt(0), mbtiScores.get(survey[i].charAt(0)) + (4 - choices[i]));
            }
        }

        for (int i = 0; i < mbtiType.length; i += 2) { // 각 MBTI 유형의 점수를 비교하여 결정
            if (mbtiScores.get(mbtiType[i]) >= mbtiScores.get(mbtiType[i + 1])) { // 두 개씩 비교하여 더 높은 점수를 가진 유형 선택
                answer.append(mbtiType[i]);
            } else {
                answer.append(mbtiType[i + 1]);
            }
        }

        return answer.toString();
    }
}
```

* `mbtiType` 배열을 통해 MBTI 유형을 정의한다.
* `mbtiScores` 맵을 사용해 각 MBTI 유형의 점수를 0으로 초기화한다.
* `survey`와 `choices` 배열을 순회하며 각 질문에 대한 점수를 계산한다.
* 선택지가 4보다 크면 동의 유형 `survey[i].charAt(1)` 에 점수를 추가한다.
* 그리고 4보다 작으면 미동의 유형 `survey[i].charAt(0)' 에 점수를 추가한다.
* 각 MBTI 유형의 쌍을 비교하여 더 높은 점수를 가진 유형을 선택한다.
* 결과를 문자열로 결합하여 최종 MBTI 유형을 반환한다.