## 문자열 내 p와 y의 개수

<br>

### 책 참조 전 상태의 코드
```java
class Solution {
  boolean solution(String s) {
    boolean answer;
    int charP = 0;
    int charY = 0;
    s = s.toLowerCase();

    for (char c : s.toCharArray()) {
      if(c == 'p') {
        charP++;
      } else if (c == 'y') {
        charY++;
      }
    }
    
    return answer = charP == charY ? true : false;
  }
}
```

<br>

### 책 참조 후 상태의 코드
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

* 변수 초기화: 
  * `p`와 `y`의 개수를 세기 위한 변수 `ps`와 `ys`를 0으로 초기화한다.

* 문자열 순회: 
  * 문자열 `s`를 한 문자씩 순회한다.

* 개수 세기:
  * `switch` 문을 사용하여 각 문자가 `p`, `P`, `y`, `Y` 중 하나인지 확인하고, 해당하는 경우에 `ps` 또는 `ys`를 1씩 증가시킨다.
  * 대소문자 구분 없이 개수를 세기 위해 `switch` 문에서 대문자와 소문자를 함께 처리한다.

* 결과 반환: 
  * `ps`와 `ys`의 값이 같은지 비교하여 같으면 true, 다르면 `false`를 반환한다.