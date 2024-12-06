## 올바른 괄호

### 책 참조 전 상태의 코드
```java
import java.util.Stack;

class Solution {
    
    public boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            switch(c) {
                    case '(' -> stack.push(c);
                    case ')' -> {
                        if (stack.isEmpty()) {
                            return false;
                        }
                        
                        stack.pop();
                    }
            }
        }

        return stack.isEmpty();
    }
    
}
```

### 책 참조 후 상태의 코드
```java
import java.util.Stack;

public class Solution {
    
    public boolean solution(String s) {
        int counter = 0;
        
        for (char c : s.toCharArray()) {
            switch(c) {
                case '(' -> counter++;
                case ')' -> {
                    if (counter-- == 0) return false;
                }
            }
        }
        
        return counter == 0;
    }
    
}
```