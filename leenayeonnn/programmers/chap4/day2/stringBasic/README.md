[프로그래머스 - 문자열 다루기 기본](https://school.programmers.co.kr/learn/courses/30/lessons/12918)

---

<br/>

- 문자열 길이 = 4 or 6
- 숫자로만 구성

<br/>

---

### 내 풀이
```java
class Solution {
    public boolean solution(String s) {

        // 길이 확인
		if(s.length() != 4 && s.length() != 6) {
			return false;
		}

        // parseInt 진행시 예외 발생
        // => 문자열에 숫자 외 문자 포함
		try{
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
    }
}
```

<br/>

---

### 교재 풀이

- 정규 표현 활용

```java
public class Solution {
    public boolean solution(String s) {
        return s.matches("[0-9]{4}|[0-9]{6}");
    }
}
```

<br/>

- isDigit 활용

```java
public class Solution {
    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) return false;
        
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        
        return true;
    }
}
```