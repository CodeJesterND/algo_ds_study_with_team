## 시저 암호

<br>

### 책 참조 전 상태의 코드
```java
class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(Character.isLowerCase(c)) {
                sb.append((char)('a' + (c - 'a' + n) % 26));
            }
            else if(Character.isUpperCase(c)) {
                sb.append((char)('A' + (c - 'A' + n) % 26));
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```

<br>

### 책 참조 후 상태의 코드
```java
class Solution {
    private char push(char c, int n) {
        if (!Character.isAlphabetic(c)) {
            return c;
        }

        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % ('Z' - 'A' + 1);
        return (char) (offset + position);
    }

    public String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            builder.append(push(c, n));
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