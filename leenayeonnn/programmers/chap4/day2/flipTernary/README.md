[프로그래머스 - 3진법 뒤집기](https://school.programmers.co.kr/learn/courses/30/lessons/68935)

---

<br/>

- n 진법 계산
    - 나눠지지 않을때 까지 n으로 나눈 나머지들을 역순으로 진열
- 3진번 후, 앞뒤를 뒤집음
    - 나눈 나머지를 역순이 아닌 그대로 사용

<br/>

---

### 내 풀이
```java
class Solution {
    public int solution(int n) {
		StringBuilder sb = new StringBuilder();

        // 들어온 값이 나눠지지 않을때까지 수행
		while (n > 0) {

            // 나눈 나머지를 순서대로 추가
			int remain = n % 3;
			sb.append(remain);
			n /= 3;
		}
		
        // parseInt 를 이용해 3진법을 10진법으로 변경
	    return Integer.parseInt(sb.toString(), 3);
    }
}
```

<br/>

---

### 교재 풀이
```java
public class Solution {
    public int solution(int n) {
        String str = Integer.toString(n, 3);
        String reversed = new StringBuilder(str).reverse().toString();
        return Integer.valueOf(reversed, 3);
    }
}
```