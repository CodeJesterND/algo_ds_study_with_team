# [link](https://school.programmers.co.kr/learn/courses/30/lessons/64061)

## 문제 풀이

```
import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i <moves.length; i++){
            for(int j=0; j<board.length; j++){
                int num = board[j][moves[i]-1];
                if(num != 0) {
                    if(stack.isEmpty()) {
                        stack.push(num);
                    } else if(stack.peek()== num) {
                        stack.pop();
                        answer+=2;
                    } else {
                        stack.push(num);
                    }
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        return answer;    
    }       
}
```

1. Stack을 선언해주었다. 해당 부분은 넣어줄 부분이다. 
2. board[j][move[i]-1] 로 0행부터 하나씩 내려가며 숫자가 존재한지 판단.
3. 숫자가 존재한다면, isEmpty 동일하다면 pop후에 answer에 두개를 넣어준다.
4. 그게 아니라면 단순히 push만 해준다. 
5. 존재하는 부분에 대한 부분에 처리가 완료되면 0으로 처리해준 후, break 해준다. 
