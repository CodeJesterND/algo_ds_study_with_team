[프로그래머스 - 문자열 압축](https://school.programmers.co.kr/learn/courses/30/lessons/60057)


---

<br/>

```java
class Solution {
    public int solution(String s) {

        // 길이가 1이면 압축 필요 X
		if(s.length() == 1){
			return 1;
		}

		int answer = Integer.MAX_VALUE;

        // 단위를 1 ~ 문자열길이 로 설정해서 압축 수행
		for (int len = 1; len < s.length(); len++) {
			StringBuilder sb = new StringBuilder();

            // 맨 처음 기준 문자 추출 위한 idx 설정
			int startIdx = 0;
			int endIdx = len;
			int count = 1;

			while (endIdx <= s.length()) { // 범위 확인
				String standardStr = s.substring(startIdx, endIdx);

                // 비교를 위한 다음 문자 추출
				startIdx = endIdx;
				endIdx = startIdx + len;

				while (endIdx <= s.length()) { // 범위 확인
					String comparedStr = s.substring(startIdx, endIdx);

                    // 다르면 빠져나옴
					if (!comparedStr.equals(standardStr)) {
						break;
					}

                    // 같으면 카운트 증가 & 다음 비교를 위한 idx 설정
					count++;
					startIdx = endIdx;
					endIdx = startIdx + len;
				}

                // 기준 단어 연속 중복에 따른 출력값 추가
				if (count == 1) {
					sb.append(standardStr);
				} else {
					sb.append(count).append(standardStr);
				}
				count = 1;
			}

            // 마지막에 남은 문자열을 뒤에 추가
			if (startIdx < s.length()) {
				sb.append(s.substring(startIdx));
			}

			answer = Math.min(answer, sb.length());
		}

		return answer;
    }
}  
```