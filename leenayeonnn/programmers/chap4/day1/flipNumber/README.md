[프로그래머스 - 자연수 뒤집어 배열로 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12932)


---

<br/>

```java
class Solution {
    public int[] solution(long n) {
        
		// StringBuilder 의 reverse 이용해서 뒤집기
		String str = String.valueOf(new StringBuilder(Long.toString(n)).reverse());

        // 문자 '0'을 각 자리수의 숫자에서 빼줌
        // => 해당 숫자 문자를 숫자형으로 변경
		int[] answer = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			answer[i] = str.charAt(i) - '0';
		}
        
        return answer;
    }
}
```