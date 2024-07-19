## [Link](https://school.programmers.co.kr/learn/courses/30/lessons/68935)
## 3진법 뒤집기

1. append를 3으로 나머지해서 보낸다. 
2. n을 3으로 나눈다.
3. time은 진법이 진행되는 것 만큼이고 거꾸로 뒤집어서 뒤에부분부터 반대로 진행하여 answer 더함. 
4. time*=3 나오는 이유는 곱해주어 하나씩 answer 더해준다. 

```
class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n%3);
            n /= 3;
        }
        
        int time = 1;
        for(int i = sb.length()-1; i>=0; i--){
            answer += (sb.charAt(i) - '0') * time;
            time *= 3;
        }
        return answer;
    }
}
```


# 책 문제
### 1. Integer.toString(n, 3)으로 3진법으로 바꿔준다.
### 2. Integer.valueOf(reversed,3) 으로 3진법으로 꺼꾸로 출력해주었다. 
```
class Solution {
    public int solution(int n) {
        String str = Integer.toString(n, 3);
        
        String reversed = new StringBuilder(str).reverse().toString();
        return Integer.valueOf(reversed, 3);
    }
}
```