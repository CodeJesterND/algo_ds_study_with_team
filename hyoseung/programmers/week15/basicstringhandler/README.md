## 문자열 다루기

<br>

### 책 참조 전 상태의 코드
```java
class Solution {
  public boolean solution(String s) {
    if (s.length() != 4 && s.length() != 6) {
      return false;
    }
    
    try {
      Integer.parseInt(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
```

<br>

### 책 참조 후 상태의 코드
```java
class Solution {
  public String solution(String s, int n) {
    if (s.length() != 4 && s.length() != 6) {
      return false;
    }

    for (char c : s.toCharArray()) {
      if (!Character.isDigit(c)) {
        false;
      }
    }
    
    return true;
  }
}
```

* 길이 확인:
  * 입력 문자열 `s`의 길이가 4 또는 6이 아닌 경우, 숫자로만 구성된 길이 4 또는 6의 문자열이라는 조건에 위배되므로 즉시 `false`를 반환한다. 
  * 이는 if 문을 사용하여 간단히 확인할 수 있다.

* 숫자 여부 확인:
  * 문자열 s를 `s.toCharArray()`를 사용하여 각 문자를 배열로 변환하여 하나씩 검사한다.
  * `Character.isDigit(c)`를 사용하여 각 문자 `c`가 숫자인지 확인한다.
  * 만약 숫자가 아닌 문자가 하나라도 발견되면, 즉시 `false`를 반환한다.

* 유효성 확인:
  * 위의 두 단계를 모두 통과했다면, 문자열 s는 숫자로만 구성되어 있고 길이가 4 또는 6이라는 조건을 만족하므로 `true`를 반환한다.