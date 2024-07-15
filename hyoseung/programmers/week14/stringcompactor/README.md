## 문자열 압축

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {

  private List<String> split(String source, int length) {
    List<String> tokens = new ArrayList<>();
    for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
      int endIndex = startIndex + length;
      if (endIndex > source.length()) endIndex = source.length();
      tokens.add(source.substring(startIndex, endIndex));
    }
    return tokens;
  }

  private int compress(String source, int length) {
    StringBuilder builder = new StringBuilder();
    String last = "";
    int count = 0;
    for (String token : split(source, length)) {
      if (token.equals(last)) {
        count++;
      } else {
        if (count > 1) builder.append(count);
        builder.append(last);
        last = token;
        count = 1;
      }
    }
    if (count > 1) builder.append(count);
    builder.append(last);
    return builder.length();
  }

  public int solution(String s) {
    int min = Integer.MAX_VALUE;
    for (int length = 1; length <= s.length(); length++) {
      int compressed = compress(s, length);
      if (compressed < min) {
        min = compressed;
      }
    }
    return min;
  }
}
```

* 모든 경우의 수 탐색: 
  * 문자열을 1개부터 `s`의 길이까지의 모든 단위로 잘라 압축하는 경우를 탐색한다.ㅋㅋㅋ
* 압축 함수 구현: 
  * 각 단위로 문자열을 잘라 압축하고, 압축된 문자열의 길이를 계산하는 `compress` 함수를 구현한다.
* 최소 길이 비교: 
  * 압축된 문자열의 길이를 비교하여 가장 짧은 길이를 찾는다.