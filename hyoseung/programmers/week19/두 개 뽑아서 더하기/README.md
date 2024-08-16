## 두 개 뽑아서 더하기

<br/>

### 책 참조 전 상태의 코드
```java
import java.util.TreeSet;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>();

        // 각 쌍의 합을 set에 추가
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        // set을 배열로 변환하여 반환
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

<br/>

### 책 참조 후 상태의 코드
```java
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
```