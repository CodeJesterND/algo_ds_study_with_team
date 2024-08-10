## 수식 최대화

<br/>

### 책 참조 전 상태의 코드
```java
import java.util.*;

class Solution {
    
    // 가능한 연산자 우선순위 조합을 저장하는 리스트
    private static final String[][] priorityOrders = {
        {"+", "-", "*"},
        {"+", "*", "-"},
        {"-", "+", "*"},
        {"-", "*", "+"},
        {"*", "+", "-"},
        {"*", "-", "+"}
    };
    
    public long solution(String expression) {
        long maxResult = 0;
        
        // 모든 우선순위 조합에 대해 수식 계산
        for (String[] order : priorityOrders) {
            List<String> tokens = parseExpression(expression);
            
            for (String op : order) {
                tokens = calculate(tokens, op);
            }
            
            long result = Math.abs(Long.parseLong(tokens.get(0)));
            
            maxResult = Math.max(maxResult, result);
        }
        
        return maxResult;
    }
    
    // 연산자를 기준으로 expression을 파싱하여 토큰 리스트를 반환
    private List<String> parseExpression(String expression) {
        List<String> tokens = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        
        for (char ch : expression.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*') {
                tokens.add(number.toString());
                tokens.add(String.valueOf(ch));
                number = new StringBuilder();
            } else {
                number.append(ch);
            }
        }
        
        tokens.add(number.toString());
        
        return tokens;
    }
    
    // 주어진 연산자를 적용하여 수식을 계산하고, 결과 리스트를 반환
    private List<String> calculate(List<String> tokens, String operator) {
        List<String> newTokens = new ArrayList<>();
        long acc = 0;
        
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            
            if (token.equals(operator)) {
                long operand1 = Long.parseLong(newTokens.remove(newTokens.size() - 1));
                long operand2 = Long.parseLong(tokens.get(++i));
                
                switch (operator) {
                    case "+":
                        acc = operand1 + operand2;
                        break;
                    case "-":
                        acc = operand1 - operand2;
                        break;
                    case "*":
                        acc = operand1 * operand2;
                        break;
                }
                
                newTokens.add(String.valueOf(acc));
                
            } else {
                newTokens.add(token);
            }
        }
        
        return newTokens;
    }
}
```

### 책 참조 후 상태의 코드
```java
import java.util.*;

class Solution {
    private static final String[][] precedences = {
        "+-*".split(""),
        "+*-".split(""),
        "-+*".split(""),
        "*+-".split(""),
        "*-+".split("")
    };
    
    private long calculate(long lhs, long rhs, String op) {
       return switch(op) {
            case "+" -> lhs + rhs;
            case "-" -> lhs - rhs;
            case "*" -> lhs * rhs;
            default -> throw new IllegalArgumentException("Invalid operator: " + op);
        };
    }
    
    private long calculate(List<String> tokens, String[] precedence) {
        for(String op: precedence) {
            for(int i = 0; i < tokens.size(); i++) {
                if(tokens.get(i).equals(op)) {
                    long lhs = Long.parseLong(tokens.get(i-1));
                    long rhs = Long.parseLong(tokens.get(i+1));
                    long result = calculate(lhs, rhs, op);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.add(i-1, String.valueOf(result));
                    i -= 2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }
    
    public long solution(String expression) {
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        
        while(tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
        
        long max = 0;
        for(String[] precedence : precedences) {
            long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
            if(value> max) {
                max = value;
            }
        }
        return max;
    }
 
}
```