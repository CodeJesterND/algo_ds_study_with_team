## 거리두기 확인하기

```java
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            if (isValidRoom(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    private boolean isValidRoom(String[] room) {
        int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (room[i].charAt(j) == 'P') {
                    // 상하좌우 검사
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (isValidPosition(ni, nj) && room[ni].charAt(nj) == 'P') {
                            return false;
                        }
                        if (isValidPosition(ni, nj) && room[ni].charAt(nj) == 'O') {
                            for (int dd = 0; dd < 4; dd++) {
                                int nni = ni + dx[dd];
                                int nnj = nj + dy[dd];
                                if (isValidPosition(nni, nnj) && !(nni == i && nnj == j) && room[nni].charAt(nnj) == 'P') {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}
```

* 상하좌우 이동을 나타내는 `dx`, `dy` 배열을 정의한다.
* 각 대기실을 5x5 배열로 순회하면서 사람이 앉아 있는 `P`를 찾는다.
* `P`를 찾으면 상하좌우로 다른 `P`가 있는지 확인한다.
* 만약 있다면, 사회적 거리두기가 지켜지지 않았으므로 `false`를 반환한다.
* `P` 주변에 빈 테이블 `O`이 있는 경우, 그 빈 테이블의 상하좌우에 또 다른 `P`가 있는지 확인합니다. 
* 만약 있다면, 역시 사회적 거리두기가 지켜지지 않았으므로 `false`를 반환합니다.
* 모든 검사를 통과하면 `true`를 반환한다.