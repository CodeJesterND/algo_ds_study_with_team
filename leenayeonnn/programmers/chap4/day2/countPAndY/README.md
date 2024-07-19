[프로그래머스 - 문자열 내 p와 y의 개수](https://school.programmers.co.kr/learn/courses/30/lessons/12916)

---

<br/>

- 문자열 내 p, y의 개수 비교
    - 같으면 true
    - 다르면 false
- 대소문자 구분 X

<br/>

---

### 내 풀이
```java
class Solution {
    boolean solution(String s) {

        // 대소문자 구분 X => 다 소문자로 변경
		s = s.toLowerCase();

        // 필터를 이용해 각각 p, y 만 추출해서 길이 계산
		int countP = s.chars().filter(ch -> ch == 'p').toArray().length;
		int countY = s.chars().filter(ch -> ch == 'y').toArray().length;

		return countP == countY;
    }
}
```

<br/>

---

### 교재 풀이

- 각각 p, y를 없앤 문자열 길이를 기존 문자열 길이에서 빼서 개수 계산

```java
public class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();

        int ps = s.length() - s.replace("p", "").length();
        int ys = s.length() - s.replace("y", "").length();
        return ps == ys;
    }
}
```

<br/>

- 문자열 내부를 돌면서 직접적으로 개수 확인

```java
public class Solution {
    boolean solution(String s) {
        int ps = 0;
	    int ys = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case 'p', 'P' -> ps++;
                case 'y', 'Y' -> ys++;
            }
        }

        return ps == ys;
    }
}
```