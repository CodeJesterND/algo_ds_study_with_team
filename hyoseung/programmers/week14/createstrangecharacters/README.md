## 이상한 문자 만들기

<br>

### 책 참조 전 상태의 코드
```java
class Solution {
  public String solution(String s) {
    StringBuilder answer = new StringBuilder();
    String[] words = s.split(" "); 

    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      for (int j = 0; j < word.length(); j++) {
        char ch = word.charAt(j);
        if (j % 2 == 0) {
          answer.append(Character.toUpperCase(ch)); 
        } else {
          answer.append(Character.toLowerCase(ch)); 
        }
      }
      if (i != words.length - 1) {
        answer.append(" ");
      }
    }
    return answer.toString();
  }
}
```

<br>

### 책 참조 후 상태의 코드
```java
class Solution {
  public String solution(String s) {
    StringBuilder builder = new StringBuilder();
    boolean toUpper = true;

    for (char c : s.toCharArray()) {
      if (!Character.isAlphabetic(c)) {
        builder.append(c);
        toUpper = true;
      } 
      else {
        if (toUpper) {
          builder.append(Character.toUpperCase(c));
        } 
        else {
          builder.append(Character.toLowerCase(c));
        }
        toUpper = !toUpper;
      }
    }

    return builder.toString();
  }
}
```

* 문자열 순회: 
  * 주어진 문자열 `s`를 한 문자씩 순회한다.
  
* 알파벳 판별: 
  * 현재 문자가 알파벳인지 확인한다.

* 밀기 연산:
  * 알파벳이라면 대문자인지 소문자인지 판별하여 적절한 `offset` 값(`A` 또는 `a`)을 설정한다.
  * 문자의 현재 위치를 계산하고, 밀 이동 거리 `n`을 더한 후, 알파벳 범위를 벗어나지 않도록 나머지 연산을 수행한다.
  * 밀어낸 위치를 문자로 변환하여 결과 문자열에 추가한다.

* 결과 반환:
  * 암호화된 문자열을 `StringBuilder`를 통해 생성하고 반환한다.