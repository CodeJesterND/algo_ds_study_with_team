## 크레인 인형뽑기

```java
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int length = board[0].length;
        Stack<Integer> stack = new Stack();
        
        for (int move : moves) {
            move -= 1;
            for (int i = 0; i < length; i++) {
                if (board[i][move] != 0) { // 칸에 인형이 있을 경우...!
                    // 지금 뽑은 인형과 맨 마지막으로 장바구니에 들어간 인형이 같은 경우...!
                    if (stack.size() > 0 && stack.peek() == board[i][move]) { 
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[i][move]); // 인형 넣기
                    }
                    board[i][move] = 0; // 뽑은 칸은 0으로 비워줌
                    break;
                }
            }
        }
        
        return answer;
    }
}
```

* `answer`를 0으로 초기화하여 터트려진 인형의 개수를 저장한다.
* `length`를 board 배열의 열 길이로 설정한다.
* 인형을 임시로 저장할 스택 `stack`을 생성한다.
* `moves` 배열을 순회하며 각 움직임을 처리한다.
* `move` 값을 1 감소시켜 0부터 시작하는 인덱스로 변환한다.
* 각 열을 위에서 아래로 탐색하여 인형이 있는지 확인한다. (`board[i][move] != 0`)
* 인형이 있으면 스택의 맨 위 인형과 현재 뽑은 인형을 비교한다.
* 스택의 맨 위 인형과 같으면 스택에서 인형을 제거하고, 터트려진 인형의 개수를 2 증가시킨다.
* 다르면 현재 뽑은 인형을 스택에 넣는다.
* 뽑은 인형의 자리는 0으로 비운다.
* 인형을 뽑은 후, 더 이상 해당 열을 탐색하지 않고 다음 움직임으로 넘어간다.
* 터트려진 인형의 개수를 저장한 `answer` 를 반환한다.