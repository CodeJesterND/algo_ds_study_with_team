## [link](https://school.programmers.co.kr/learn/courses/30/lessons/150370)

## 개인정보 수집 유효기간 - 문제 풀이

```
import java.util.*;

class Solution {
    static int MONTH = 28;
    static int YEAR = 12;
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0;i<terms.length; i++){
            String []t=terms[i].split(" ");
            map.put(t[0], Integer.parseInt(t[1])* MONTH);
        }
        String []todays = today.split("\\.");
        
        int todayYear = Integer.parseInt(todays[0]);
        int todayMonth = Integer.parseInt(todays[1]);
        int todayDay = Integer.parseInt(todays[2]);
        
        int targetDay = (todayYear*MONTH*YEAR) + (todayMonth*MONTH) + todayDay;
        int count = 0;
        for(int i=0; i<privacies.length; i++){
            String []privacy = privacies[i].split(" ");
            String []dates = privacy[0].split("\\.");
            
            int year = Integer.parseInt(dates[0]);
            int month = Integer.parseInt(dates[1]);
            int day = Integer.parseInt(dates[2]);
            
            int calcDay = (year*MONTH*YEAR) + (month*MONTH) + day + map.get(privacy[1]);
            
            if(targetDay >= calcDay) {
                list.add(i+1);
            }
        }
        return list;
    }
}
```
## Key-Point 모든 달의 마지막일이 28일이 핵심 요소이다.
1. MONTH , YEAR 에 대한 상수 변수를 선언해주었다.
2. 파기되어야할 정보들이 들어가야 할 ArrayList를 선언해주었다.
3. Map<String, Integer> map = new HashMap<>() 여기에는 기간이 들어 갈 예정이다.
4. todays를 \\. 로 나누어준다. 각각을 오늘 날짜에 변수에 담아준다.
5. targetDay를 일수로 바꿔준다.
6. privacies를 돌면서 계약기간에 해당하지 않는 것들을 구해준다. 