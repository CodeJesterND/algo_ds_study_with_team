## 숫자 짝꿍

```java
class Solution {
    public String solution(String X, String Y) {
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        
        for (char c : X.toCharArray()) {
            xCount[c - '0']++;
        }
        
        for (char c : Y.toCharArray()) {
            yCount[c - '0']++;
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int count = Math.min(xCount[i], yCount[i]);
            for (int j = 0; j < count; j++) {
                answer.append(i);
            }
        }
        
        if (answer.length() == 0) {
            return "-1";
        }
        
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer.toString();
    }
}
```

* `xCount` 와 `yCount` 배열은 각각 `X` 와 `Y` 의 각 자릿수 0부터 9까지의 등장 횟수를 저장하기 위한 배열이다.
* `X` 와 `Y` 를 순회하면서 각 `char`를 정수로 변환하여 해당하는 인덱스의 카운트를 증가시킨다. 
* 예를 들어, `X` 에서 '3'이 나오면 `xCount[3]` 의 값을 증가시킨다.
* 역순으로 9부터 0까지 순회하면서, `xCount` 와 `yCount` 배열에서 각 숫자의 등장 횟수를 비교하여 최소값을 구한다.
* 최소값이 있는 만큼 해당 숫자를 `answer` 문자열에 추가한다.
* 만약 `answer` 문자열의 길이가 `0` 이면, 공통된 숫자가 없는 경우이므로 `-1` 을 반환한다.
* 그렇지 않고, `answer` 의 첫 번째 문자가 '0' 이면, 모든 숫자가 0으로만 이루어진 경우이므로 `0` 을 반환한다.
* 그 외의 경우에는 `answer` 문자열을 그대로 반환한다.