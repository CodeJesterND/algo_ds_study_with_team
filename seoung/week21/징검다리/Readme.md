## [link](https://school.programmers.co.kr/learn/courses/30/lessons/43236?language=java)


## 징검다리
## 문제 풀이 

1.이진 탐색의 기준을 거리로 잡는다. 
2.기준 값보다 사이의 있는 값이 작을 시, 바위를 삭제해준다.
3.맨마지막 바위 위치도 거리를 잰다. 
4.큰 횟수를 기준으로 mid를 줄일지 늘리지 정해준다. 
```
import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int start = 0;
        int end = distance;
        
        int result = distance;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            int prev = 0;
            
            for(int i=0; i<rocks.length; i++) {
                if(rocks[i] - prev < mid) {
                    cnt++;
                } else {
                    prev = rocks[i];
                }
                
                if(cnt > n) break;
            }
            
            if(distance - prev < mid) {
                cnt++;
            }
            
            if(cnt > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
                result = mid;
            }
            
        }
        
        
        return result;
    }
}

```


```
for(int i = 0; i < rocks.length; i++) {
    if(rocks[i] - prev < mid) {
        cnt++; // 거리가 mid보다 작으면 바위 제거
    } else {
        prev = rocks[i]; // 거리가 충분히 크면 바위를 유지
    }
    
    if(cnt > n) break; // n개 초과 제거하면 바로 종료
}

```

두 바위 간의 거리가 mid보다 작으면 해당 바위를 제거하고 (cnt를 증가시킴), 그렇지 않으면 그 바위를 유지하고 prev를 갱신합니다. 

```
if(distance - prev < mid ) {
        cnt++; // 거리가 mid보다 작으면 바위 제거
    }
```
도착 지점까지 거리 확인: 마지막 바위와 도착 지점 사이의 거리도 확인해야 합니다. 만약 이 거리가 mid보다 작으면 cnt를 증가시킨다.


```
if(cnt > n) {
    end = mid - 1; // 너무 많이 제거했으면 mid 줄임
} else {
    start = mid + 1; // 충분히 바위를 제거했으니 mid를 키움
    result = mid; // 현재 mid 값이 가능한 최소 거리
}
```