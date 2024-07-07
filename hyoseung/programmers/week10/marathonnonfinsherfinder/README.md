## 완주하지 못한 선수

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>(); // 참가자 이름과 인원 수를 저장할 Map 생성 Why? 동명이인 처리를 위해서!
        
        for (String p : participant) { // 참가자 명단을 Map 추가 
            map.put(p, map.getOrDefault(p, 0) + 1); // getOrDefault() 활용해 동명이인 처리..!
        }
        
        
        for (String c : completion) { // 완주한 선수들의 이름을 이용해 출전 인원수를 하나씩 감소시킨다.
            map.put(c, map.get(c) - 1); // 완주한 선수의 출전 인원 수를 감소시킨다.
        }
        
        for (String key : map.keySet()) { // 출전 인원수가 0이 아니라면 완주하지 못한 상태...
            if (map.get(key) != 0) {
                answer += key;
                break; // 생각해보니...단 한 명의 선수를 제외하고는 다 완주한다는 문맥을 잊고 있었다...ㅠ.ㅠ
            }
        }
        
        return answer;
    }
}
```

* 참가자 이름과 인원 수를 저장할 `HashMap` 을 생성한다.
* 참가자 목록을 순회하면서 각 참가자의 이름을 `HashMap`에 추가하고, 동명이인의 경우 카운트를 증가시킨다.
* 완주자 목록을 순회하면서 `HashMap` 에서 해당 이름의 카운트를 감소시킨디ㅏ.
* `HashMap` 을 순회하면서 값이 0이 아닌 완주하지 못한 참가자를 찾는다.
* 완주하지 못한 참가자를 찾으면 결과에 저장하고, 반복문을 종료한다.
* 최종적으로 완주하지 못한 참가자의 이름을 반환한다.