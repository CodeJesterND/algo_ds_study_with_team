[프로그래머스 - 신고결과받](https://school.programmers.co.kr/learn/courses/30/lessons/92334)

---
## 아이디어
1. 리스트를 이용해서 신고 내역 관리  
	- 리스트는 들어온 유저 순서대로 신고 내역을 관리함 
	- 리스트는 Set 으로 이루어짐  
	- 각 Set 은 각 유저를 신고한 유저의 번호를 저장함 (번호 = 유저 리스트 idx) 
2. 리스트를 이용해 전송할 메일 수 확인

</br>

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
		List<Set<Integer>> reportById = new ArrayList<>();
		for (String id : id_list) {
			reportById.add(new HashSet<>());
		}

		for (String eachReport : report) {
			StringTokenizer st = new StringTokenizer(eachReport);
			String reporter = st.nextToken();
			String reportedPerson = st.nextToken();

			int reportedIdx = Arrays.asList(id_list).indexOf(reportedPerson);
			int reporterIdx = Arrays.asList(id_list).indexOf(reporter);
			reportById.get(reportedIdx).add(reporterIdx);
		}

		int[] answer = new int[reportById.size()];
		for (int i = 0; i < reportById.size(); i++) {
			Set<Integer> reporters = reportById.get(i);
			if (reporters.size() >= k) {
				for (int reporter : reporters) {
					answer[reporter]++;
				}
			}
		}
        
        return answer;
    }
}
```