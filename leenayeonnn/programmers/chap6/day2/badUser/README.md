[프로그래머스 - 불량 사용자](https://school.programmers.co.kr/learn/courses/30/lessons/64064)

---

### 내 풀이
```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> matchs = new ArrayList<>();
        for (int i = 0; i < banned_id.length; i++) {
            String pattern = banned_id[i].replaceAll("\\*", "[a-z0-9]");

            List<String> match = new ArrayList<>();
            for (String userId : user_id) {
                if (userId.matches(pattern)) {
                    match.add(userId);
                }
            }
            matchs.add(match);
        }

        Set<Set<String>> bans = new HashSet<>();
        findBans(matchs, 0, bans, new HashSet<>());

        return bans.size();
    }
    
        private static void findBans(List<List<String>> matchs, int idx, Set<Set<String>> bans, Set<String> ban) {
        if (idx == matchs.size()) {
            bans.add(new HashSet<>(ban));
            return;
        }

        for (String id : matchs.get(idx)) {
            if (ban.contains(id)) {
                continue;
            }

            ban.add(id);
            findBans(matchs, idx + 1, bans, ban);
            ban.remove(id);
        }
    }
}
```

<br/>

---

### 교재 풀이

```java
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    private void count(int index, Set<String> banned,
                       String[][] bans, Set<Set<String>> banSet) {
        if (index == bans.length) {
            banSet.add(new HashSet<>(banned));
            return;
        }

        for (String id : bans[index]) {
            if (banned.contains(id)) continue;
            banned.add(id);
            count(index + 1, banned, bans, banSet);
            banned.remove(id);
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        String[][] bans = Arrays.stream(banned_id)
                .map(banned -> banned.replace('*', '.'))
                .map(banned -> Arrays.stream(user_id)
                        .filter(id -> id.matches(banned))
                        .toArray(String[]::new))
                .toArray(String[][]::new);

        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);
        return banSet.size();
    }
}
```

