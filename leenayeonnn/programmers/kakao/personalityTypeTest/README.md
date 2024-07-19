[프로그래머스 - 성격유형검사](https://school.programmers.co.kr/learn/courses/30/lessons/118666)

---
## 아이디어
1. 각각 특성을 key 값으로 가진 Map 을 이용해 점수 관리
	- 설문조사 유형의 맨 앞 알파벳을 이용해 해당 특성에 점수 부여 (-3 ~ 3점)
2. 각 특성의 점수 확인해서 결과 확인
	- 유형을 비교 (ex - RT) 해서 더 큰 쪽 선택
	- 동점 시, 알파벳 순으로 빠른거 선택
	- 특성 배열을 만들때, 미리 유형별 & 알파벳 순 으로 정리

</br>

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
		char[] personalities = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
		Map<Character, Integer> scores = new HashMap<>();
		for (char personality : personalities) {
			scores.put(personality, 0);
		}

		for (int i = 0; i < survey.length; i++) {
			scores.put(survey[i].charAt(0), scores.get(survey[i].charAt(0)) + (4 - choices[i]));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < personalities.length; i += 2) {
			if (scores.get(personalities[i]) < scores.get(personalities[i + 1])) {
				sb.append(personalities[i + 1]);
			} else{
				sb.append(personalities[i]);
			}
		}
        
        return sb.toString();
    }
}
```