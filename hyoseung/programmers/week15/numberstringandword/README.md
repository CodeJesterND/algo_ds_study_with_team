## 숫자 문자열과 영단어

<br>

### 책 참조 전 상태의 코드
```java
class Solution {
  public int solution(String s) {
    String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    for (int i = 0; i < arr.length; i++) {
      if (s.contains(arr[i])) {
        s = s.replace(arr[i], Integer.toString(i));
      }
    }

    return Integer.parseInt(s);
  }
}
```

<br>

### 책 참조 후 상태의 코드
```java
public class Solution {
  private static final String[] words = {
          "zero", "one", "two", "three", "four",
          "five", "six", "seven", "eight", "nine",
  };

  public int solution(String s) {
    for (int i = 0; i < words.length; i++) {
      s = s.replace(words[i], Integer.toString(i));
    }
    
    return Integer.parseInt(s);
  }
}
```

* 영단어와 숫자 매핑: 
  * 영단어와 숫자를 연결하는 배열을 만든다.

* 문자열 탐색 및 변환: 
  * 주어진 문자열 s를 반복하면서 영단어가 발견되면 해당 숫자로 변환한다. 
  * 이 과정을 `words`를 순회하며 수행한다.

* 정수 변환: 
  * 변환된 문자열을 `Integer.parseInt()`를 사용하여 정수로 변환하고 반환한다.