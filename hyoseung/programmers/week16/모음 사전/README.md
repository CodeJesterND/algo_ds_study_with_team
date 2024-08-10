## 모음 사전

<br/>

### 책 참조 전 상태의 코드
```java
class Solution {
    int answer;
    int index;
	
    public int solution(String word) {   	
        dfs(word, "");        
        return answer;
    }
    
    public void dfs(String word, String text) {
    	if(answer > 0) return;
    	
        if(word.equals(text)) {
    		answer = index;
    	}
    	
        index++;
    	if(text.length() == 5) {    		
    		return;
    	}
    	
    	dfs(word, text+"A");
    	dfs(word, text+"E");
    	dfs(word, text+"I");
    	dfs(word, text+"O");
    	dfs(word, text+"U");
    }
}
```

### 책 참조 후 상태의 코드
```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final char[] CHARS = "AEIOU".toCharArray();

    private List<String> generate(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);

        if (word.length() == 5) return words;

        for (char c : CHARS) {
            words.addAll(generate(word + c));
        }
        return words;
    }

    public int solution(String word) {
        return generate("").indexOf(word);
    }
}
```