## 괄호 회전하기 
## [link] (https://school.programmers.co.kr/learn/courses/30/lessons/76502)

## 문제 풀이
1. 타당성 검토 메소드 구현 -> position을 통해 시작 위치에서 하나씩 더해서 올바른 위치에 있는지 확인하기  
2. process 메서드에서 ), }, ] 만 stack push why? pop을 해서 현재 위치해서 구해지는 값을 비교하기 위하여 
3. isValidate 안에 stack 선언하기 매번 타당성을 확일 할 때, 초기화하여 가져와야하기 때문에, static으로 전역 변수 선언 x 
4. stream 에서 final 값이 아니면 원자값 AutomicInteger로 포장하여 사용

````
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Solution {
    
    public int solution(String s) {
        
        char[] str = s.toCharArray();
        
        AtomicInteger answer = new AtomicInteger(0);
        IntStream.range(0, str.length)
            .forEach(position -> {
                if(isValidate(position, str)) {
                    answer.incrementAndGet();
                }
            });
       
        return answer.get();
    }
    
    
    private static boolean isValidate(int position, char[] str) {
        Stack<Character> stack = new Stack<>();
        
        try{
            IntStream.range(0, str.length)
                .mapToObj(i-> str[(position+i) % str.length])
                .forEach(ch -> process(ch, stack));
        } catch(IllegalArgumentException e) {
            return false;
        }
        
        return stack.isEmpty();
    }
    
    private static void process(char ch, Stack<Character> stack) {
        switch(ch) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                case ')', '}', ']' -> {
                    if(stack.isEmpty() || stack.pop() != ch) throw new IllegalArgumentException(); 
                }
        }
    }
}
````