## 3진법 뒤집기

<br>

### 책 참조 전 상태의 코드
```java
class Solution {
  public int solution(int n) {
    StringBuilder result = new StringBuilder();

    while (n > 0) {
      int remainder = n % 3; // 나머지 값을 진법 변환 값으로 활용
      result.insert(0, remainder); // 나머지를 문자열 앞에 삽입
      n /= 3; // 진법 공식은 몫이 0일 때까지 계속 나눔
    }

    result.reverse(); // 결과 뒤집기

    int answer = Integer.parseInt(result.toString(), 3);

    return answer;
  }
}
```

<br>

### 책 참조 후 상태의 코드
```java
public class Solution {
  public int solution(int n) {
    String str = Integer.toString(n, 3);
    String reversed = new StringBuilder(str).reverse().toString();
    
    return Integer.valueOf(reversed, 3);
  }
}
```

* 3진법 변환:
  * `Integer.toString(n, 3)`을 사용하여 주어진 10진수 `n`을 3진수 문자열로 변환한다.

* 문자열 뒤집기:
  * `StringBuilder(str).reverse().toString()`을 사용하여 3진수 문자열을 뒤집는다.

* 10진법 변환:
  * `Integer.parseInt(reversed, 3)`을 사용하여 뒤집힌 3진수 문자열을 다시 10진수 정수로 변환한다.