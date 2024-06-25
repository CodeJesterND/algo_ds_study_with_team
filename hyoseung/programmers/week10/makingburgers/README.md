## 햄버거 만들기

```java
import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>(); // 재료 스택 생성

        for (int ingr : ingredient) {
            stack.push(ingr); // 현재 재료를 스택에 추가

            if (stack.size() >= 4) {
                int size = stack.size();

                if (stack.get(size - 1) == 1
                        && stack.get(size - 2) == 3
                        && stack.get(size - 3) == 2
                        && stack.get(size - 4) == 1) {

                    answer++; // "[1, 3, 2, 1]" 패턴일 경우 햄버거 완성...!

                    // 사용된 재료들 제거...!
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return answer;
    }
}
```

* `ingredient` 배열의 각 요소를 저장할 `Stack<Integer>`인 `stack`을 생성한다.
* `ingredient` 배열을 순회하면서 각 재료 `ingr`를 스택에 추가한다.
* 스택의 크키가 4이상인 경우, 가장 최근에 추가된 4개의 재료가 `[1, 3, 2, 1]` 패턴인지 확인한다.
* 패턴이 일치하면 햄버거가 완성되었으므로 `answer` 를 증가시키고, 해당 재료들을 스택에서 제거한다.
* 모든 재료를 처리한 후 완성된 햄버거의 개수 `answer` 를 증가시키고, 해당 재료들을 스택에서 제거한다.