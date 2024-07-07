## 문자열 나누기

```java
class Solution {
    public int solution(String s) {
        int answer = 0;
        int startIndex = 0;

        while (startIndex < s.length()) {
            int xCount = 1;
            int otherCount = 0;
            char x = s.charAt(startIndex);
            int secondIndex = startIndex + 1;

            while (secondIndex < s.length()) {
                if (s.charAt(secondIndex) == x) {
                    xCount++;
                } else {
                    otherCount++;
                }

                if (xCount == otherCount) {
                    answer++;
                    startIndex = secondIndex + 1;
                    break;
                }

                secondIndex++;
            }

            if (secondIndex == s.length()) {
                answer++;
                break;
            }
        }

        return answer;
    }
}
```

* 주어진 문자열을 순회하면서 시작 인덱스를 기준으로 현재 문자와 같은 문자열의 개수와 다른 문자열의 개수를 센다.
* 같은 문자열의 개수와 다른 문자열의 개수가 동일한 경우, 문자열을 나눈 것으로 판단하고 나눈 횟수를 증가시킨다.
* 나눈 후에는 다음 시작 인덱스를 설정하여 문자열을 순회한다.
* 주어진 문자열을 모두 순회한 후에는 나눈 횟수를 반환한다.