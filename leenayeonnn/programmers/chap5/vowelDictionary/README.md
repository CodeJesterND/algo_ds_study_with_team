[프로그래머스 - 모음사전](https://school.programmers.co.kr/learn/courses/30/lessons/84512)

---

### 내 풀이
```java
import java.util.Arrays;
import java.util.List;

class Solution {
    
	private static final char[] VOWELS = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        return method(word, "");
    }
    
	private static int method(String word, String preWord) {
		int count = 0;
		if (preWord.length() == 5) {
			return count;
		}

		for (int i = 0; i < 5; i++) {
			String newWord = preWord + VOWELS[i];
			
            if (word.compareTo(newWord) < 0) {
				return count;
			}
            
            count++;

			if (word.equals(newWord)) {
				return count;
			}
			count += method(word, newWord);
		}

		return count;
	}
}
```

<br/>

---

### 교재 풀이

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final char[] CHARS = "AEIOU".toCharArray();

    private void generate(String word, List<String> words) {
        words.add(word);

        if (word.length() == 5) return;
        for (char c : CHARS) {
            generate(word + c, words);
        }
    }

    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }
}
```

