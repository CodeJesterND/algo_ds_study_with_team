## 데이터 분석

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

* `colOrder` 맵을 생성하여 각 열의 이름을 인덱스로 매핑한다.
* `filteredData` 리스트를 생성하여 필터링된 데이터를 저장할 준비를 한다.
* `data` 배열을 순회하면서 각 항목의 값을 검사한다.
* `ext` 에 해당하는 열의 값이 `val_ext` 보다 작은 항목들을 `filteredData` 리스트에 추가한다.
* `filteredData` 리스트를 `sort_by` 열을 기준으로 정렬한다.
* `Comparator.comparingInt`을 사용하여 각 항목의 해당 열 값을 기준으로 비교한다.
* 필터링되고 정렬된 데이터를 2차원 배열 `answer` 에 복사한다.
* `filteredData` 리스트의 각 항목을 `answer` 배열에 차례로 복사한다.
* 최종적으로 필터링되고 정렬된 데이터를 포함하는 2차원 배열 `answer`를 반환한다.