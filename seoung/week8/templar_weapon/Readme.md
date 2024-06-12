# 기사단원의 무기
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/136798)

## 문제 풀이
1. 약수 찾기를 최적화 시켜주기
2. 제곱근이면 하나 제곱근이 아니면 두 개를 구해준다. (대칭되는 값까지 추가해준다.)

```
import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        
        for(int i=1; i<=number; i++){
            int count = 0;
            for(int j=1; j*j<=i; j++){ // j*j == j 
                if(j*j == i) count++;
                else if(i%j == 0) count+=2; // 1과 자신의 경우 2개 
            }
            
            answer += count > limit ? power : count;
        }
        
        
        return answer;
    }
}
```

## 약수 최적화
```
for(int i=1; i*i <= number; i++) {
    if(i * i == number) cnt++;
    else if(number % i == 0) cnt+=2;
}
```