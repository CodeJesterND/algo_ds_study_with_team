## 자연수 뒤집어 배열로 만들기

<br>

### 책 참조 전 상태의 코드
```java
class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);

        int[] answer = new int[s.length()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(s.substring(answer.length - 1 - i, answer.length - i));
        }

        return answer;
    }
}
```

<br>

### 책 참조 후 상태의 코드
```java
class Solution {
    public int[] solution(int n) {
        String str = Long.toString(n);
        String reversed = new StringBuilder(str).reverse().toString();
        
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i] - '0';
        }
        
        return result;
    }
}
```

* 자연수를 문자열로 변환:
    * `Long.toString(n)`을 사용하여 자연수 n을 문자열로 변환한다.


* 문자열 뒤집기:
    * `StringBuilder`를 사용하여 문자열을 뒤집는다.
    * `.reverse().toString()` 메서드를 통해 뒤집힌 문자열을 얻는다.


* 문자열을 정수 배열로 변환:
    * `toCharArray()`를 사용하여 문자열을 문자 배열로 변환한다.
    * 각 문자에서 `0`을 빼서 정수로 변환하여 정수 배열 `result`에 저장한다.