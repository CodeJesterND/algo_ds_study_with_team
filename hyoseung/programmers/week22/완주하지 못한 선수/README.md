## 완주하지 못한 선수

<br/>

### 책 참조 전 상태의 코드
```java
import java.util.Arrays;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        
        return participant[participant.length - 1];
    }
}
```

<br/>

### 책 참조 후 상태의 코드
```java
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String solution(String[] participant, String[] completions) {
        Map<String, Integer> count = new HashMap<>();
        
        for (String name : participant) {
            count.putIfAbsent(name, 0);
            count.put(name, count.get(name) + 1);
        }
        
        for (String name : completions) {
            int v = count.get(name) - 1;
            count.put(name, v);
            if (v == 0) count.remove(name);
        }
        
        return count.keySet().iterator().next();
    }
}
```