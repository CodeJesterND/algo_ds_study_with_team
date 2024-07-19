[프로그래머스 - 삼각 달팽이](https://school.programmers.co.kr/learn/courses/30/lessons/87377)

---
<br/>

- 💡 가로 세로 크기가 같음
	- 행, 열 크기가 같은 2차원 배열 사용 (왼쪽으로 밀면 직각삼각형으로 변신함)

- ✔️ 교재 해설 확인 - 2번째 방법
    - dx, dy 배열 사용
	- 직접 설정 X / 배열 돌면서 자동으로 이동할 좌표 설정 가능

<br/>

---

<br/>

```java
class Solution {
    public int[] solution(int n) {

        // 삼각형 가로 세로와 같은 크기의 2차원 배열 생성		
        int[][] board = new int[n][n];

        // 시작할 idx 및 값 설정
		int x = 0;
		int y = -1;
		int num = 1;

        // 끝날때 까지 반복
		while (true) {

            // 하향
			while (y + 1 < n && board[y + 1][x] == 0) {
				board[++y][x] = num++;
			}

            // 하향 끝 후 오른쪽으로 갈 수 있는지 확인
			// 못가면 값 채우기 끝
			if (x + 1 >= n || board[y][x + 1] != 0) {
				break;
			}

            // 우향
			while (x + 1 < n && board[y][x + 1] == 0) {
				board[y][++x] = num++;
			}

            // 좌상향 가능 여부
			if (board[y - 1][x - 1] != 0) {
				break;
			}

            // 좌상향
			while (board[y - 1][x - 1] == 0) {
				board[--y][--x] = num++;
			}

            // 하향 가능 여부
			if (board[y + 1][x] != 0) {
				break;
			}
		}

		int[] answer = new int[num - 1];
		for (int i = 0; i < n; i++) {
			System.arraycopy(board[i], 0, answer, i * (i + 1) / 2, i + 1);
		}
        
        return answer;
    }
}
```