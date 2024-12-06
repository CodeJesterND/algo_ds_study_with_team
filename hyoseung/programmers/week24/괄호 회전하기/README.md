## 괄호 회전하기

### 책 참조 전 상태의 코드
```java
import java.util.Stack;

class Solution {
    
    private boolean isCorrect(char[] str, int index) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < str.length; i++) {
            
            char c = str[(index + i) % str.length];
            
            switch(c) {
                    case '(' -> stack.push(')');
                    case '{' -> stack.push('}');
                    case '[' -> stack.push(']');
                    case ')', '}', ']' -> {
                        if(stack.isEmpty()) {
                            return false;
                        }
                        if(stack.pop() != c) {
                            return false;
                        }
                    }
            }
        }
        
        return stack.isEmpty();
    }

    public int solution(String s) {
        char[] str = s.toCharArray();
        int count = 0;

        for(int index = 0; index < str.length; index++) {
            if (isCorrect(str, index)) {
                count++;
            }
        }

        return count;
    }
    
}
```

<br/>

### 책 참조 후 상태의 코드
```java
import java.util.Stack;

public class Solution {
    
    private boolean isCorrect(char[] str, int offset) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < str.length; i++) {
            char c = str[(offset + i) % str.length];
            switch (c) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                case ')', '}', ']' -> {
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != c) return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    public int solution(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        
        for (int offset = 0; offset < str.length; offset++) {
            if (isCorrect(str, offset)) {
                count++;
            }
        }
        
        return count;
    }
    
}
```
