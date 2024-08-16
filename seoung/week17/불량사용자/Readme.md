## [불량사용자](https://school.programmers.co.kr/learn/courses/30/lessons/64064)



1. id 값이 있는지 확인 없다면 for 계속 진행
2. id 값을 체크한다. 길이와 * 그리고, banned_id 전체가 충족되어야함.
3. 이렇게 되면 해당 banned_id기준으로 들어오는데 이게 하나씩 깊어지면서 comb 조합의 경우의 수를 구할 수 있다.


```
import java.util.*;

class Solution {
    
    String[] userIds;
    String[] bannedIds;
    boolean[] visited;
    HashSet<HashSet<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        userIds = user_id;
        bannedIds = banned_id;
        visited = new boolean[userIds.length];
        
        dfs(new HashSet<>(), 0);
        
        return result.size();
    }
    
    void dfs(HashSet<String> set, int depth) {
        if(depth == bannedIds.length) {
            result.add(set);
            return ;
        }
        
        for(int i=0; i < userIds.length; i++) {
            if(set.contains(userIds[i])) {
                continue;
            }
            
            if(check(userIds[i], bannedIds[depth])){
                set.add(userIds[i]);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(userIds[i]);
            }
        }
        
    }

    boolean check(String userId, String bannedId) {
        if(userId.length() != bannedId.length()) {
            return false;
        }
        
        boolean match = true;
        for(int i=0; i< userId.length(); i++) {
            if(bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                match = false;
                break;
            }
        }
        
        return match;
    }
    
}
```

# 책 문제 풀이

```
import java.util.*;

class Solution {
    
    private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
        if(index == bans.length) {
            banSet.add(new HashSet<>(banned));
            return ;
        }
        
        for(String id: bans[index]) {
            if(banned.contains(id)) continue;
            banned.add(id);
            count(index + 1, banned, bans, banSet);
            banned.remove(id);
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        String[][] bans = Arrays.stream(banned_id)
            .map(banned -> banned.replace('*', '.'))
            .map(banned -> Arrays.stream(user_id)
                .filter(id-> id.matches(banned))
                .toArray(String[]::new))
            .toArray(String[][]::new);
        
        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);
        return banSet.size();
    }
    
}
```