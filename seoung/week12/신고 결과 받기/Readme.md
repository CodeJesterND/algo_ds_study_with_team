## [link](https://school.programmers.co.kr/learn/courses/30/lessons/92334)

## 신고 결과 받기 - 문제 풀이


```
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int []answer = new int[id_list.length];
        Map<String, HashSet<String>> map = new HashMap<>(); 
        HashMap<String, Integer> position = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++) {
            map.put(id_list[i], new HashSet<>());
            position.put(id_list[i],i);
        }
        
        for(String r : report) {
            String []person = r.split(" ");
            String from = person[0];
            String to = person[1];
            map.get(to).add(from);

        }
        
        for(int i=0;i<id_list.length; i++){
            HashSet<String> sends = map.get(id_list[i]);
            if(k<=sends.size()){
                for(String sender : sends){
                    answer[position.get(sender)]++;
                }
            }
        }     
        
        return answer;
    }
}
```
![img.png](img.png)

---

1. map에 해당하는 유저 id에 해당하는 애들이 신고한 명단이 들어간다.
2. HashMap<String, Integer> position = new HashMap<>() id_list에 어느 위치에 있는지 알려주는 map을 하나 선언해주었다.
3. id_list를 for문으로 반복하면서 값을 세팅해준다. 이때,  map, position 둘 다 세팅해준다.
4. report에서 r을 split을 통해서 넣어주고 from to 로 나누어 map에다가 신고한 유저를 담아준다. 이때, HashSet을 사용한 이유가 나오는데 중복된 것은 한명으로 쳐줘야하기 떄문에 해당 방식으로 구현했다.
5. HashSet을 id_list 해당하는 아이디에 가져오면서 k번 이상 신고 당한 사이즈만 sends에 있는 사람들 수 만큼 즉 신고한 사람 수 만큼 증가 시켜준다. 