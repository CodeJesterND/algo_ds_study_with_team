[프로그래머스 - 시저 암호](https://school.programmers.co.kr/learn/courses/30/lessons/12926)


---

<br/>

```java
class Solution {
    public String solution(String s, int n) {

        // StringBuilder 를 이용해 가변 처리
        StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch == ' ') { // 공백은 그대로 사용
				sb.append(' ');
			} else if (ch <= 'Z' && ch + n > 'Z' || ch + n > 'z') { // 이동된 값이 알파벳 범위를 벗어나면 앞으로 이동
				sb.append((char)(ch - (26 - n)));
			} else { // 그냥 이동
				sb.append((char)(ch + n));
			}
		}
        
        return sb.toString();
    }
}    
```