## 올바른 괄호 
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/12909)

### 문제 풀이
1. '(' 스택에 push
2. ')' 만날 경우 pop
3. ')' 만났는데 비어있는 경우 에러 IllegalArgumentException
4. 람다를 사용하여 비어서 만듬
5. return 시, stack비어있는 경우만 true, 있는 경우 모든 괄호 만나지 못함 false
````
import java.util.*;

class Solution {
   
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        try{
            s.chars()
             .mapToObj(ch -> (char) ch)
             .forEach(ch -> processCharacter(ch, stack));
        } catch(IllegalArgumentException e) {
            return false;
        }
        
    
        return stack.isEmpty();
    }
    
    private static void processCharacter(char ch, Stack<Character> stack) {
        switch(ch) {
                case '(' -> stack.push(ch);
                case ')' -> {
                    if(stack.isEmpty()) throw new IllegalArgumentException("순서 값 오류");
                    stack.pop();
                }
        }
    }

    
    
}
````