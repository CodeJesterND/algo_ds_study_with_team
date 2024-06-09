## 2016년

```java
class Solution {
    public String solution(int a, int b) {
        String[] daysOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] daysOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;
        
        
        for (int i = 0; i < a - 1; i++) {
            totalDays += daysOfMonth[i];
        }
        totalDays += b - 1; 
        
        return daysOfWeek[(totalDays + 5) % 7];
    }
}
```

* 요일을 저장하는 배열과 각 달의 일 수를 저장하는 배열을 선언한다.
* 입력받은 월에 해당하는 일 수를 누적하여 더한다.
* 입력받은 일을 더한다.
* 총 일 수에서 특정한 날짜를 기준으로 나눈 나머지를 요일 배열의 인덱스로 사용하여 해당 요일을 반환한다.