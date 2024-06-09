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
