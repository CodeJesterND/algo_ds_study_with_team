## 이진 변환 반복하기

<br>

### 책 참조 전 상태의 코드
```java
class Solution {
  public int[] solution(String s) {
    int[] answer = new int[2];

    while (s.length() > 1) {
      int count = 0;

      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '0') {
          answer[1]++;
        } else {
          count++;
        }
      }

      s = Integer.toBinaryString(count);
      answer[0]++;
    }

    return answer;
  }
}
```

<br>

### 책 참조 후 상태의 코드
```java
public class Solution {
  private int countZeros(String s) {
    int zeros = 0;
    for (char c : s.toCharArray()) {
      if (c == '0') zeros++;
    }
    return zeros;
  }

  public int[] solution(String s) {
    int loop = 0;
    int removed = 0;
    while (!s.equals("1")) {
      int zeros = countZeros(s);
      loop += 1;
      removed += zeros;

      int ones = s.length() - zeros;
      s = Integer.toString(ones, 2);
    }

    return new int[] {loop, removed};
  }
}
```

* 0 개수 세는 함수 `countZeros`: 
  * 문자열에서 `0`의 개수를 세는 함수를 별도로 정의한다.

* 반복문: 
  * 문자열 s가 "1"이 될 때까지 반복한다.
  
* 0 제거 및 개수 세기: 
  * `countZeros` 함수를 이용하여 `0`의 개수를 `removed` 변수에 누적한다.

* 길이를 이진수로 변환: 
  * `1`의 개수 `s.length()` - `zeros`를 2진수 문자열로 변환하고, 이를 다음 반복에서 사용할 새로운 `s`로 설정한다.

* 변환 횟수 증가: 
  * `loop`를 1 증가시킨다.

* 결과 반환: 
  * 반복이 끝나면 `[loop, removed]` 배열을 반환한다.