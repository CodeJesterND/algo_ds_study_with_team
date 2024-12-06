# 등굣길

## 교안 참조 전 상태의 코드

```java
public class Solution {
    public int solution(int n) {
        int answer = 0;

        int a = 0; // 첫 항
        int b = 1; // 두 항

        /*
         * 피보나치 수열의 첫 두 항(0과 1)을 a와 b에 초기화했으므로
         * i는 2부터 시작한다.
         */
        for (int i = 2; i <= n; i++) {
            answer = (a + b) % 1234567;
            a = b;
            b = answer;
        }

        return answer;
    }
}
```

<br/>

## 교안 참조 이후 상태의 코드

```java

```