## 콜라 문제
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/132267) 

```
class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n/a > 0){
            answer += n / a * b;
            n = n / a * b + n % a;     
        }
        return answer;
    }
}
```

1. 마트에 주어야 하는 병수 a , b 는 빈 병 a 를 주면 가져다 주는 b
2. 그러면 n / a 를 나누면 총 개수에서 b를 곱해주면 빈병을 가져다 주어 받은 콜라수이다. 
3. n / a * b는 빈병을 주어 받은 수 n % a 총 수에서 나머지를 구해준 것이다 빈병을 주어 받은 수와 남은 수를 해야 현재 빈 병 개수를 얻을 수 있음.
4. while(n/a > 0)는 더이상 빈 병을 주었을 때, 나누어지는 수가 없으면 조건문을 빠져나옴.