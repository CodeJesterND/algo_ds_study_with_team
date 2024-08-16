## 불량 사용자

<br/>

### 책 참조 전 상태의 코드
```java
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Set<String>> resultSet = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        backtrack(user_id, banned_id, new HashSet<>(), 0);
        return resultSet.size();
    }
    
    private void backtrack(String[] user_id, 
                           String[] banned_id, 
                           Set<String> currentSet, 
                           int index) {
        
        if (index == banned_id.length) {
            resultSet.add(new HashSet<>(currentSet));
            return;
        }
        
        String pattern = banned_id[index];
        for (String user : user_id) {
            if (matches(user, pattern) && !currentSet.contains(user)) {
                currentSet.add(user);
                backtrack(user_id, banned_id, currentSet, index + 1);
                currentSet.remove(user);
            }
        }
    }
    
    private boolean matches(String user, String pattern) {
        if (user.length() != pattern.length()) return false;
        
        for (int i = 0; i < user.length(); i++) {
            if (pattern.charAt(i) != '*' && user.charAt(i) != pattern.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}
```

### 책 참조 후 상태의 코드
```java
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
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
    
    private void count(int index, Set<String> banned,
                       String[][] bans, 
                       Set<Set<String>> banSet) {
        
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
}
```