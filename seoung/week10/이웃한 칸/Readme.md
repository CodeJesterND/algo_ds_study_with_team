## [link](https://school.programmers.co.kr/learn/courses/30/lessons/250125)

## 문제풀이

```
class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int []dh = {0, 1, -1, 0};
        int []dw = {1, 0, 0, -1};
        
        for(int i=0; i<=3; i++) {
            int h_check = dh[i] + h;
            int w_check = dw[i] + w;
            
            if(w_check >= 0 && w_check < n && h_check >= 0 && h_check < n){
                if(board[h][w].equals(board[h_check][w_check])){
                    answer++;
                }
            }
        }
        return answer;
    }
}
```

1. dh , dw를 통하여 움직일 배열에 x,y축을 넣어준다.
2. for문을 통해서 상하좌우를 체크해준다. 그래서 동일한 색이 있으면 answer를 올려주었다. 
