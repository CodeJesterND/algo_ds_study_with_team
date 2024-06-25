## 이웃한 칸

```java
class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length; // 첫번째 문항
        int count = 0; // 두번째 문항

        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        for (int i = 0; i <= 3; i++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if (0 <= h_check && h_check < n && 0 <= w_check && w_check < n) { // 상, 하, 좌, 우 범위 확인...!
                if (board[h][w].equals(board[h_check][w_check])) {
                    count+=1;
                }
            }
        }

        return count;
    }
}
```

* `n`은 `board`의 길이로 설정된다. 이는 배열의 행 수를 나타낸다.
* `count` 는 주어진 좌표 `h`, `w` 주변의 같은 값의 개수를 세는 변수이다.
* `dh`와 `dw` 배열은 각각 상, 하, 좌, 우 방향으로 이동할 때의 행과 열의 변화를 나타낸다.
* 예를 들어, 상은 행을 하나 줄이고, 하는 행을 하나 늘리는 식이다.
* `for` 루프를 통해 상, 하, 좌, 우 네 방향을 모두 탐색합니다.
* 각 방향으로 이동한 새로운 좌표 `h_check` 와 `w_check` 가 배열의 범위 내에 있는지 확인합니다.
* 범위 내에 있고, `board[h][w]` 와 `board[h_check][w_check]` 의 값이 같으면 `count` 를 증가시킵니다.
* 모든 방향에 대해 같은 값의 개수를 센 후 `count` 값을 반환합니다.