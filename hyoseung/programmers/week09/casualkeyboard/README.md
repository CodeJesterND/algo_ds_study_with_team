## 대충 만든 자판

```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> keyCount = new HashMap<>();


        for (String key : keymap) {
            for (int j = 0; j < key.length(); j++) {
                char ch = key.charAt(j);
                keyCount.put(ch, Math.min(keyCount.getOrDefault(ch, 101), j + 1));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (char ch : targets[i].toCharArray()) {
                if (!keyCount.containsKey(ch)) {
                    sum = -1;
                    break;
                } else {
                    sum += keyCount.get(ch);
                }
            }
            answer[i] = sum;
        }

        return answer;
    }
}
```

* 우선, `keymap` 배열에 있는 각 문자열을 반복하면서 문자와 해당 위치 값을 `keyCount` 맵에 저장한다.
* 이 때, 이미 저장된 문자가 있다면 현재 위치 값과 기존의 위치 값을 비교하여 작은 값을 선택하여 저장한다.
* 다음으로, `targets` 배열에 있는 각 문자열을 반복하면서 각 문자가 `keyCount` 맵에 있는지 확인하고, 있다면 해당 위치 값을 더하여 결과 배열에 저장한다.
* 만약 `keyCount` 맵에 해당 문자가 없다면 -1을 결과에 저장한다.
* 마지막으로, 결과 배열을 반환한다.