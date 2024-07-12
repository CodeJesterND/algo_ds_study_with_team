## 삼각 달팽이

```java
class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2]; 
        int[][] tri = new int[n][n];
        
        int x = -1; 
        int y = 0; 
        int num = 1; 
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) { 
                    x++;
                }
                else if (i % 3 == 1) { 
                    y++;
                }
                else if (i % 3 == 2) { 
                    x--;
                    y--;
                }
                tri[x][y] = num++;
            }
        }
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tri[i][j] == 0) break;
                answer[index++] = tri[i][j];
            }
        }
        
        return answer;
    }
}
```

* 크기가 n x n인 2차원 배열 `tri`를 생성하여 삼각형 형태로 숫자를 채운다.
* 0은 빈 공간을 의미한다.
* 3가지 경우 `i % 3 == 0`, `i % 3 == 1`, `i % 3 == 2`에 따라 좌표 `x, y`를 이동하며 숫자를 채운다.
* `i % 3 == 0`: 아래로 이동 
* `i % 3 == 1`: 오른쪽으로 이동 
* `i % 3 == 2`: 왼쪽 위 대각선으로 이동 
* 삼각형 배열 `tri`를 순회하며 0이 아닌 값들을 차례로 answer 배열에 추가한다.