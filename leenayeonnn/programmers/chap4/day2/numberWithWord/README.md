[프로그래머스 - 숫자 문자열과 영단어](https://school.programmers.co.kr/learn/courses/30/lessons/81301)

---

<br/>

- 입력된 문자열에서 숫자 영단어를 숫자로 치환

<br/>

---

### 내 풀이
```java
class Solution {
    
    // 각 인덱스에 맞는 숫자 영단어 설정
    private static final String[] NUM_WORDS = {
		"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
	};
    
    public int solution(String s) {

        // 문자열 존재하는 모든 영단어를 숫자로 치환
		for(int i = 0; i < NUM_WORDS.length; i++) {
			s = s.replaceAll(NUM_WORDS[i], String.valueOf(i));
		}
        
        return Integer.parseInt(s);
    }
}
```

<br/>

---

### 교재 풀이

- 동일