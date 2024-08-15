## H-Index

<br/>

### 책 참조 전 상태의 코드
```java
import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        // 먼저 배열을 오름차순으로 정렬
        Arrays.sort(citations);

        int n = citations.length;

        // h번 이상 인용된 논문이 h편 이상인지 확인
        for (int i = 0; i < n; i++) {
            // h는 남은 논문의 개수
            int h = n - i; 
            
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}
```

<br/>

### 책 참조 후 상태의 코드
```java
import java.util.Arrays;

class Solution {
    private boolean isValid(int[] citations, int h) {
        int index = citations.length - h;
        return citations[index] >= h;
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        for (int h = citations.length; h >= 1; h--) {
            if (isValid(citations, h)) return h;
        }
        return 0;
    }
}
```