# 2016년
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/12901)


## 문제 풀이
1. LocalDateTime을 이용하여 풀었다. 
2. 풀이라고 할 건 없다 아래에 메소드를 정리하자.
```
import java.util.*;
import java.time.*;
import java.time.format.*;
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        LocalDate date = LocalDate.of(2016, a, b);
        
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        answer = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
        
        
        return answer;
    }
}
```

## [LocalDateTime Docs Link](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)
## [DayOfWeek](https://docs.oracle.com/javase/8/docs/api/java/time/DayOfWeek.html)
<br>

> LocalDateTime 
>> of : public static LocalDate of(int year, Month month, int dayOfMonth) 지정된 연도, 현지 시간을 반환한다.<br>
>> getDayOfWeek : 주일의 주간 필드를 얻는다. <br>
>> public String getDisplayName(TextStyle style, Locale locale) : 텍스트 스타일에 반환을 선택한다.  