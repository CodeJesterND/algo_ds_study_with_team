## [link](https://school.programmers.co.kr/learn/courses/30/lessons/43238)

## 입국심사

## 문제 풀이
```
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
       
        long start = 1;
        long end = (long) times[times.length-1] * n;
        long answer = end;
    
        while(start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            
            for(int time : times) {
                sum += mid / time;
            }
            
            
            if(sum >= n) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
}
```

```
Arrays.sort(times);
long start = 1;
long end = (long) times[times.length-1] * n;
long answer = end;
```

- 최소한 일초가 걸리기에 start = 1 대입해줌
- end는 최악의 시간을 넣어주어야하기에 가장 오래 걸리는 시간으로 했다. 
- 여기서 Arrays.sort 를 해준 이유는 최악시간이 맨뒤어 없을 수도 있기에 해주었다.


```
while (start <= end) {
    long mid = (start + end) / 2;
    long sum = 0;
    
    for (int time : times) {
        sum += mid / time;
    }

```

- while(start<=end) 이진 탐색을 실행하는 반복문이다. 가능한 시간 범위에서 최소 시간을 찾아가는 과정이다.
- mid = (start + end) / 2 중간값을 구합니다. 
- 각 심사관이 mid시간 동안 몇명을 처리할 수 이쓴ㄴ지 사람의 수를 계산한다. 
- 각 심사관이 처리할 수 있는 수를 sum에 저장합니다. 

```
if (sum >= n) {
    answer = mid;
    end = mid - 1;
} else {
    start = mid + 1;
}
```

- 심사시간 동안 n명이상 검사 할 수 있을 시, answer = mid로 바꿔준다. 이는 더 적은 시간 안에 목표를 달성하기 위하여 해줍니다. 
- answer = mid 현재까지 찾은 최소 시간을 대입시켜준다.
- end = mid -1 심사할 수 있는 인원이 충분하므로 더 적은 시간(왼쪽 구간)에서 탐색을 계속한다.