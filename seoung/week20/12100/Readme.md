## [Link](https://www.acmicpc.net/problem/12100)

## 2048 (Easy)

```
package src.Week15.p12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, answer, map[][], copy[][];
    static int[] direct;
    static boolean[][] visit;
    static int[] dx = {0, -1, 0, 1}; // 우, 상, 좌, 하
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        direct = new int[5];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        game(5, 0);
        System.out.println(answer);
    }

    public static void game(int end, int count) {
        if (count == end) {
            confirm();
            return;
        }

        for (int i = 0; i < 4; i++) {
            direct[count] = i;
            game(end, count + 1);
        }
    }

    public static void confirm() {
        // 원본 배열을 복사하여 이동 시도
        copy = new int[n][n];
        for (int i = 0; i < n; i++)
            copy[i] = map[i].clone();

        // 지정된 방향으로 이동 수행
        for (int d = 0; d < direct.length; d++) {
            visit = new boolean[n][n];
            moveBoard(direct[d]); // 방향에 따라 보드 이동
        }

        // 이동 후 최대값 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, copy[i][j]);
            }
        }
    }

    public static void moveBoard(int dir) {
        // 각 방향에 맞게 블록을 이동시킴
        switch (dir) {
            case 0: // 우
                for (int i = 0; i < n; i++) {
                    for (int j = n - 1; j >= 0; j--) {
                        move(i, j, dir);
                    }
                }
                break;
            case 1: // 상
                for (int j = 0; j < n; j++) {
                    for (int i = 0; i < n; i++) {
                        move(i, j, dir);
                    }
                }
                break;
            case 2: // 좌
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        move(i, j, dir);
                    }
                }
                break;
            case 3: // 하
                for (int j = 0; j < n; j++) {
                    for (int i = n - 1; i >= 0; i--) {
                        move(i, j, dir);
                    }
                }
                break;
        }
    }

    public static void move(int x, int y, int dir) {
        if (copy[x][y] == 0) return;

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) return; // 범위 벗어나면 종료

            if (visit[nx][ny]) return; // 이미 합쳐진 블록이면 종료

            if (copy[nx][ny] == 0) { // 빈 공간으로 이동
                copy[nx][ny] = copy[x][y];
                copy[x][y] = 0;
                x = nx;
                y = ny;
            } else if (copy[nx][ny] == copy[x][y]) { // 같은 값이 있으면 합침
                visit[nx][ny] = true; // 합쳐졌음을 표시
                copy[nx][ny] *= 2;
                copy[x][y] = 0;
                return;
            } else {
                return; // 다른 값이 있는 경우 더 이동하지 않음
            }
        }
    }
}

```

```
static int n, answer, map[][], copy[][];
static int[] direct;
static boolean[][] visit;
static int[] dx = {0, -1, 0, 1}; // 우, 상, 좌, 하에 대한 x축 변화
static int[] dy = {1, 0, -1, 0}; // 우, 상, 좌, 하에 대한 y축 변화
```

- n: 보드 크기
- answer: 만들 수 있는 가장 큰 값
- map[][] : 원래 보드 상태
- copy[][] : 보드를 이동할 때 사용하는 임시 보드
- direct[] : 이동 방향을 저장한느 배열 각 재귀 단계마다 상,하,좌,우 4방향을 저장
- visit[][] : 한번 합쳐진 블록이 다시 합쳐지지 않도록 방문 체크해주는 배열
- dx, dy : 이동방향에 대한 좌표 변화


```
public static void game(int end, int count) {
    if (count == end) {
        confirm();
        return;
    }

    for (int i = 0; i < 4; i++) {
        direct[count] = i;
        game(end, count + 1);
    }
}
```

## game 함수 (재귀 DFS 탐색)
- DFS 재귀 호출: 4방향(상, 하, 좌, 우)을 모두 탐색하기 위한 DFS(깊이 우선 탐색)입니다.
- 종료 조건: count==end 5번의 이동을 완료한 것이므로, 그 상태에서 가장 큰 블록 값을 구하기 위해 confirm()함수를 호출한다.
- direct[count] = i: 각 count별로 상(0), 하(1), 좌(2), 우(3)의 네 가지 방향으로 이동을 시도한다.

```
public static void confirm() {
    // 원본 배열을 복사하여 이동 시도
    copy = new int[n][n];
    for (int i = 0; i < n; i++)
        copy[i] = map[i].clone();

    // 지정된 방향으로 이동 수행
    for (int d = 0; d < direct.length; d++) {
        visit = new boolean[n][n];
        moveBoard(direct[d]); // 방향에 따라 보드 이동
    }

    // 이동 후 최대값 찾기
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            answer = Math.max(answer, copy[i][j]);
        }
    }
}
```

- copy[][] 배열에 map[][] 복사해준다. DFS 탐색에서 각 시도마다 원래의 상태를 유지하면서 새로운 상태를 만들기 위함이다.
- 방향에 따른 이동: direct[]에 저장된 방향에따라 moveBoard 함수를 통해 블록들을 이동시킨다.
- 최대 값 계산: 이동이 끝난 후, 현재 보드에서 가장 큰 블록을 찾아 answer에 저장

```
public static void moveBoard(int dir) {
    // 각 방향에 맞게 블록을 이동시킴
    switch (dir) {
        case 0: // 우
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    move(i, j, dir);
                }
            }
            break;
        case 1: // 상
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    move(i, j, dir);
                }
            }
            break;
        case 2: // 좌
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    move(i, j, dir);
                }
            }
            break;
        case 3: // 하
            for (int j = 0; j < n; j++) {
                for (int i = n - 1; i >= 0; i--) {
                    move(i, j, dir);
                }
            }
            break;
    }
}
```

- 이 함수는 주어진 방향(dir)으로 블록을 이동시킴
- 빈칸으로 이동: 빈 칸이 있으면 그 방향으로 계속 이동한다.

## 오른쪽으로 이동
```
for (int i = 0; i < n; i++) {           // 행 순차 처리
    for (int j = n - 1; j >= 0; j--) {  // 열을 오른쪽에서 왼쪽으로 이동 (n-1에서 0으로)
        move(i, j, dir);
    }
}
```
- 이동방향: 오른쪽(우측)
- 이동순서 : 오른쪽에서 왼쪽으로 이동해야함
    - 만약 블록이 왼쪽에서 오른쪽으로 처리되면, 오른쪽에 있는 블록이 왼쪽 블록과 충돌하여 합쳐지는 일이 발생하지 않거나 잘못된 결과가 나온다.
    - 따라서 오른쪽 끝에서부터 왼쪽으로 블록을 이동시키며 합치거나 빈 공간으로 이동해야 올바른 결과가 나옵니다.

## 위로 이동
```
for (int j = 0; j < n; j++) {           // 열 순차 처리
    for (int i = 0; i < n; i++) {       // 행을 위에서 아래로 이동 (0에서 n-1로)
        move(i, j, dir);
    }
}

```
- 이동방향: 위쪽.
- 이동 순서: 위에서 아래로 이동해야합니다.
    - 상단에 있는 블록부터 처리해야만, 아래쪽에 있는 블록이 위쪽 블록과 합쳐지는 일이 제대로 발생합니다.
    - 만약 아래에서 위로 처리하면, 이미 아래쪽 블록이 위로 올라가는 중에 위쪽 블록과 충돌하지 않을 수 있습니다.

## 왼쪽으로 이동
```
for (int i = 0; i < n; i++) {          // 행 순차 처리
    for (int j = 0; j < n; j++) {      // 열을 왼쪽에서 오른쪽으로 이동 (0에서 n-1로)
        move(i, j, dir);
    }
}

```

- 이동방향: 왼쪽.
- 이동 순서: 왼쪽에서 오른쪽으로 이동해야함.
    - 왼쪽 끝에서부터 처리하면서 오른쪽 블록이 왼쪽으로 이동거나 합쳐지게 만들어야함.
    - 만약 오른쪽에서 왼쪽으로 처리하면, 블록들이 오른쪽에서 왼쪽으로 밀리기 전에 왼쪽에 있던 블록이 제대로 이동하지 않거나 합쳐지지 않는 문제가 발생할 수 있다.

## 아래로 이동
```
for (int j = 0; j < n; j++) {           // 열 순차 처리
    for (int i = n - 1; i >= 0; i--) {  // 행을 아래에서 위로 이동 (n-1에서 0으로)
        move(i, j, dir);
    }
}

```
- 이동방향: 아래쪽
- 이동순서: 아래에서 위로 이동해야 합니다.
    - 아래쪽에서부터 블록을 이동시키면, 아래에 있는 블록이 위쪽 블록과 합쳐지거나 이동할 수 있다.
    - 만약 위에서 아래로 처리하면, 이미 위쪽 블록이 아래쪽으로 내려가는 중에 아래쪽 블록과 제대로 충돌하지 않을 수 있다.


```
public static void move(int x, int y, int dir) {
    if (copy[x][y] == 0) return;

    while (true) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx < 0 || ny < 0 || nx >= n || ny >= n) return; // 범위 벗어나면 종료

        if (visit[nx][ny]) return; // 이미 합쳐진 블록이면 종료

        if (copy[nx][ny] == 0) { // 빈 공간으로 이동
            copy[nx][ny] = copy[x][y];
            copy[x][y] = 0;
            x = nx;
            y = ny;
        } else if (copy[nx][ny] == copy[x][y]) { // 같은 값이 있으면 합침
            visit[nx][ny] = true; // 합쳐졌음을 표시
            copy[nx][ny] *= 2;
            copy[x][y] = 0;
            return;
        } else {
            return; // 다른 값이 있는 경우 더 이동하지 않음
        }
    }
}

```

- 주어진 방향(dir)으로 블록을 실제로 이동시킨다.
- 빈 칸이 있으면 그 방향으로 계속 이동한다.
- 이동한 칸이 값은 값이면 합치고 더이상 이동하지 않는다.
- visit[][] 배열로 방문 처리