[프로그래머스 - 개인정보수집유효기간](https://school.programmers.co.kr/learn/courses/30/lessons/150370)

---
## 아이디어
1. 날짜 문자열을 해당 포맷을 적용해서 LocalDate 타입으로 변경 (날짜 계산을 위해)    
2. 유효 기간을 Map 으로 저장 key = 유형 / value = 유효기간  
3. 유효 기간 확인해서 알맞게 날짜 계산 후 유효한지 판단

</br>

```java
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies)  throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		LocalDate todayDate = LocalDate.parse(today, formatter);

		Map<String, Integer> termMap = new HashMap<>();
		for (String term : terms) {
			StringTokenizer st = new StringTokenizer(term);
			termMap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
		}

		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < privacies.length; i++) {
			StringTokenizer st = new StringTokenizer(privacies[i]);
			LocalDate date = LocalDate.parse(st.nextToken(), formatter);
			String privacy = st.nextToken();

			date = date.plusMonths(termMap.get(privacy));

			if(!date.isAfter(todayDate)) {
				answer.add(i + 1);
			}
		}
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
```