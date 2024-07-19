[프로그래머스 - 이진 변환 반복하기](https://school.programmers.co.kr/learn/courses/30/lessons/70129)

---

<br/>

- 문자열에서 0 제거
    - 제거된 0의 개수 필요
- 제거된 문자열의 길이를 이진으로 변경
- 문자열이 1일때 까지 반복

<br/>

---

### 내 풀이
```java
class Solution {
    public int[] solution(String s) {
		int count = 0; // 이진 변화 수
		int removeCount = 0; // 제거된 0 개수

        // 문자가 1일때 까지 반복
		while (!s.equals("1")) {
			count++; // 이진 변화 +1

            // 0 제거
			String removeS = s.replaceAll("0", "");

            // 기존 문자 길이 - 제거된 문자 길이
            // => 제거된 0 개수 확인
			removeCount += s.length() - removeS.length();

            // 길이를 2진 문자열로 변환
			s = Integer.toBinaryString(removeS.length());
		}
        
        return new int[] {count, removeCount};
    }
}
```

<br/>

---

### 교재 풀이

- 직접적으로 문자 '0'을 찾아다니면서 0 개수 확인

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