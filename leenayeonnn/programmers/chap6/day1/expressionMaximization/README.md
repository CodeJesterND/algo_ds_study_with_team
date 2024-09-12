[프로그래머스 - 수식 최대화](https://school.programmers.co.kr/learn/courses/30/lessons/67257)

---

### 내 풀이
```java
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

class Solution {
    
    private static final String[] OP = {"+", "-", "*"};
    
    public long solution(String expression) {

        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> inputs = new ArrayList<>();
        while (st.hasMoreTokens()) {
            inputs.add(st.nextToken());
        }

        long max = Long.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            long temp = Math.max(maximize(inputs, new ArrayList<>(), i, 1), maximize(inputs, new ArrayList<>(), i, 2));
            max = Math.max(max, temp);
        }

        return max;
    }
    
    private static long maximize(List<String> inputs, List<String> opPriority, int opIdx, int method) {
        opPriority.add(OP[opIdx]);

        if (opPriority.size() < 3) {
            return maximize(inputs, opPriority, (opIdx + method) % 3, method);
        }

        List<String> postfix = new ArrayList<>();
        Deque<String> opStack = new ArrayDeque<>();

        int inputsIdx = 0;

        postfix.add(inputs.get(inputsIdx++));

        while (inputsIdx < inputs.size()) {
            String op = inputs.get(inputsIdx++);

            if (op.equals(opPriority.get(0))) {
                postfix.add(inputs.get(inputsIdx++));
                postfix.add(op);
            } else if (op.equals(opPriority.get(1))) {
                if (!opStack.isEmpty() && opStack.getLast().equals(opPriority.get(1))) {
                    postfix.add(opStack.removeLast());
                }
                postfix.add(inputs.get(inputsIdx++));
                opStack.add(op);
            } else {
                while (!opStack.isEmpty()) {
                    postfix.add(opStack.removeLast());
                }
                postfix.add(inputs.get(inputsIdx++));
                opStack.add(op);
            }
        }

        while (!opStack.isEmpty()) {
            postfix.add(opStack.removeLast());
        }

        int postfixIdx = 2;
        while (postfix.size() > 1) {
            if (getOpIdx(postfix.get(postfixIdx)) == -1) {
                postfixIdx++;
                continue;
            }

            String opResult = operation(postfix.remove(postfixIdx),
                    Long.parseLong(postfix.remove(postfixIdx - 1)), Long.parseLong(postfix.remove(postfixIdx - 2)));

            postfix.add(postfixIdx - 2, opResult);

            postfixIdx--;
        }

        return Math.abs(Long.parseLong(postfix.remove(0)));
    }

    private static int getOpIdx(String s) {
        return IntStream.range(0, OP.length)
                .filter(i -> OP[i].equals(s))
                .findFirst()
                .orElse(-1);
    }

    private static String operation(String op, long num2, long num1) {
        return switch (op) {
            case "+" -> String.valueOf(num1 + num2);
            case "-" -> String.valueOf(num1 - num2);
            case "*" -> String.valueOf(num1 * num2);
            default -> "";
        };
    }
}
```

<br/>

---

### 교재 풀이

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    private static final String[][] precedences = {
            "+-*".split(""),
            "+*-".split(""),
            "-+*".split(""),
            "-*+".split(""),
            "*+-".split(""),
            "*-+".split(""),
    };

    private long calculate(long lhs, long rhs, String op) {
        return switch (op) {
            case "+" -> lhs + rhs;
            case "-" -> lhs - rhs;
            case "*" -> lhs * rhs;
            default -> 0;
        };
    }

    private long calculate(List<String> tokens, String[] precedence) {
        for (String op : precedence) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long lhs = Long.parseLong(tokens.get(i - 1));
                    long rhs = Long.parseLong(tokens.get(i + 1));
                    long result = calculate(lhs, rhs, op);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.add(i - 1, String.valueOf(result));
                    i -= 2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }

    public long solution(String expression) {
        StringTokenizer tokenizer =
                new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }

        long max = 0;
        for (String[] precedence : precedences) {
            long value = Math.abs(
                    calculate(new ArrayList<>(tokens), precedence));
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
```

