## 개인정보 수집 유효기간

```java
import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        // 정답 리스트
        List<Integer> answer = new ArrayList<>();

        // 년, 월, 일로 저장!
        int todayY = Integer.parseInt(today.substring(0, 4));
        int todayM = Integer.parseInt(today.substring(5, 7));
        int todayD = Integer.parseInt(today.substring(8, 10));

        // 0년 0월 0일부터 오늘까지의 일수
        int todayTotalDay = (todayY * 12 * 28) + (todayM * 28) + todayD;

        Map<Character, Integer> termsMap = new HashMap<>();

        // 약관 추출!
        for (String term : terms) {
            char termType = term.charAt(0);
            int termM = Integer.parseInt(term.substring(2));
            termsMap.put(termType, termM);
        }

        // 각 privacies 요소들 비교
        for (int i = 0; i < privacies.length; i++) {
            // 약관 종류 추출!
            char privacyType = privacies[i].charAt(11);

            // privacies 날짜 추출
            int privacyY = Integer.parseInt(privacies[i].substring(0, 4));
            int privacyM = Integer.parseInt(privacies[i].substring(5, 7));
            int privacyD = Integer.parseInt(privacies[i].substring(8, 10));
            int privacyTotalDay = (privacyY * 12 * 28) + (privacyM * 28) + privacyD;

            // 약관 종류에 따른 유효 기간 일자 계산
            int privacyTermM = termsMap.get(privacyType);
            int privacyTermDay = privacyTermM * 28;

            if (privacyTotalDay + privacyTermDay <= todayTotalDay) {
                answer.add(i + 1);
            }
        }

        return answer;
    }
}
```

* `todayTotalDay`: 오늘 날짜를 0년 0월 0일부터 경과된 총 일수로 변환하여 계산한다.
* `privacyTotalDay`: 개인정보 수집 일자를 0년 0월 0일부터 경과된 총 일수로 변환하여 계산한다.
* `termsMap`: 약관 종류를 `key`로, 해당 약관의 유효 기간을 `value`로 저장한다.
* `privacies`: 배열을 순회하며 각 개인정보를 처리한다.
* `privacyType`: 해당 개인정보의 약관 종류를 추출한다.
* `privacyTermDay`: `termsMap`에서 해당 약관 종류의 유효 기간을 가져와 일수로 변환한다.
* `privacyTotalDay` + `privacyTermDay`: 개인정보 수집 일자에 유효 기간을 더하여 유효 기간 만료일을 계산한다.
* 만료일이 `todayTotalDay`보다 이전이면 유효기간이 만료된 것으로 판단하여, 해당 개인정보의 번호 `i + 1`를 `answer` 리스트에 추가한다.