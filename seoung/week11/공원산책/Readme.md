# [link](https://school.programmers.co.kr/learn/courses/30/lessons/172928)

## 공원 산책 - 문제 풀이

```
import java.util.*;

class Solution {
    static int []x = {1, 0, -1, 0};
    static int []y = {0, -1, 0, 1};
    static int startX = 0;
    static int startY = 0;
    static int [][]map;
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        map = new int[park.length][park[0].length()];
        
        for(int h = 0; h < park.length; h++) {
            for(int w = 0; w < park[h].length(); w++) {
                char c = park[h].charAt(w);
                if(c == 'S') {
                    startX = w;
                    startY = h;
                } else if(c == 'X') {
                    map[h][w] = 1;    
                }
            }
        }
        
        for(String r : routes) {
            String []arr = r.split(" ");
            int index = 0;
            switch (arr[0]) {
                case "E": 
                    index = 0;
                    break;
                case "N":
                    index = 1;
                    break;
                case "W":
                    index = 2;
                    break;
                case "S":
                    index = 3;
                    break;
            }
            
            int n = Integer.parseInt(arr[1]);
            boolean canMove = true;
            for (int i = 1; i <= n; i++) {
                int nx = startX +x[index]*i;
                int ny = startY +y[index]*i;

                // 이동이 불가능한 조건 확인
                if (nx < 0 || ny < 0 || nx >= park[0].length() || ny >= park.length || map[ny][nx] == 1) {
                    canMove = false;
                    break;
                }
            }
            
            if(canMove){
                startX = startX + x[index] *n;
                startY = startY + y[index] *n;
            }
        }
        
        answer[0] = startY;
        answer[1] = startX;
        
        return answer;
    }
}
```
해당 문제는 dfs로 풀어내려고 하였으나 dfs로 풀기에는 참 애매한 부분들이 있는거 같아서 dfs로 풀지 않았다. <br/>
해당 부분은 x,y의 배열위치 값이 뜬금없이 헷갈려서 고생했음. 
1. 방향을 정해줄 x, y 배열을 선언해주었다.
2. 초기 x,y를 잡아주기 위하여 x,y를 넣어줌
3. 맵을 그려주기 위하여 map을 만들었다. 
4. 이차원 배열을 통해서 행을 먼저 h를 통해서 구했고 그 행을, w로 각각 나누어 구했다. 이 때, x라면 map[h][w] 에다가 1을 표시해주었다.
5. split을 통해서 이동방향을 잡아주고 위에서 설정해준 인덱스에 맞게 위치를 이동 이때, for문을 통하여 n만큼의 위치를 구해준다. 
6. 이동이 불가능한지 확인해주고 이를 if문을 통해서 해결해준다.