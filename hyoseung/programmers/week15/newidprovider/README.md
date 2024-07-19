## 신규 아이디 추천

<br>

### 책 참조 전 상태의 코드
```java
class Solution {
  public String solution(String new_id) {
    String answer = new_id.toLowerCase(); // 1단계

    answer = answer.replaceAll("[^-_.a-z0-9]", ""); // 2단계
    answer = answer.replaceAll("[.]{2,}", "."); // 3단계
    answer = answer.replaceAll("^[.]|[.]$", "");    // 4단계

    if (answer.isEmpty()) { // 5단계
      answer += "a";
    }

    if (answer.length() >= 16) { // 6단계
      answer = answer.substring(0, 15);
      answer = answer.replaceAll("[.]$", "");
    }

    if (answer.length() <= 2) {
      while (answer.length() < 3) {
        answer += answer.charAt(answer.length() - 1);
      }
    }

    return answer;
  }
}
```

<br>

### 책 참조 후 상태의 코드
```java
public class Solution {
  public String solution(String newId) {
    newId = newId.toLowerCase();
    newId = newId.replaceAll("[^a-z0-9-_.]", "");
    newId = newId.replaceAll("\\.+", ".");
    newId = newId.replaceAll("^\\.|\\.$", "");
    if (newId.isEmpty()) newId = "a";
    
    if (newId.length() >= 16) {
      newId = newId.substring(0, 15);
      newId = newId.replaceAll("\\.$", "");
    }
    
    while (newId.length() < 3) {
      newId += newId.charAt(newId.length() - 1);
    }
    
    return newId;
  }
}
```

* 1단계: 소문자 변환
  * `newId.toLowerCase()`를 사용하여 입력된 아이디를 모두 소문자로 변환한다.

* 2단계: 허용되지 않는 문자 제거
  * 정규 표현식 `[^a-z0-9-_.]`를 사용하여 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자를 제거한다.

* 3단계: 연속된 마침표(`.`) 하나로 치환
  * 정규 표현식 `\\.+`를 사용하여 연속된 마침표를 하나의 마침표로 치환한다.

* 4단계: 처음이나 끝에 위치한 마침표`(.)` 제거
  * 정규 표현식 `^\\.|\\.$`를 사용하여 처음이나 끝에 위치한 마침표를 제거한다.

* 5단계: 빈 문자열일 경우 `a` 대입
  * 4단계까지 진행 후 문자열이 비어있다면 `a`를 대입한다.

* 6단계: 길이가 16 이상일 경우 15개 문자로 줄이기
  * 만약 문자열 길이가 16 이상이면, 처음 15개 문자만 남긴다.
  * 만약 마지막 문자가 마침표라면 제거한다.

* 7단계: 길이가 2 이하일 경우 마지막 문자 반복 추가
  * 문자열 길이가 2 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 추가한다.