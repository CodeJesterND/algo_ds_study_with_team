[프로그래머스 - 이상한 문자 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12930)


---

<br/>

```java
class Solution {
    public String solution(String s) {
        
		StringBuilder sb = new StringBuilder();

        // 현재 위치가 짝수, 홀수 인지 확인
        // true = 짝수 = 대문자
		boolean flag = true;

		for (char c : s.toCharArray()) {
			if (c == ' ') { // 공백 = 그대로
				sb.append(c);
				flag = true; // 공백 기준으로 짝,홀수 설정
				continue;
			}

            // 짝, 홀수에 따라 알파벳 변경
			if (flag) {
				sb.append(Character.toUpperCase(c));
			} else {
				sb.append(Character.toLowerCase(c));
			}

            // 짝 <-> 홀
			flag = !flag;
		}
        
        return sb.toString();
    }
}       
```