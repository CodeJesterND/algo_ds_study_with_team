[프로그래머스 - 거리두기 확인하기](https://school.programmers.co.kr/learn/courses/30/lessons/81302)

---

<br/>

### Try 1 - 5번 테스트 실패

- 순차적으로 돌면 이전에서 체크를 진행하기에 상측, 좌측을 체크할 필요가 없기때문에 확인 구간을 줄여서 풀어보자
	- 1차 체크시 -> 우측, 하측
	- 2차 체크시 -> 우측 => 우측, 하측 / 하측 => 우측, 하측, 좌측

```java
public class Distancing2 {

	// 이동 거리 설정 / idx 0 = 우측 / 1 = 하측 / 2 = 좌측(2번째 탐색시 하측에 대해서만 적용)
	private static final int[] DX = {1, 0, -1};
	private static final int[] DY = {0, 1, 0};

	public static void main(String[] args) {
		String[][] places = {
			{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
			{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
			{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
			{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
		};

		int[] answer = new int[5];

		// 각 방 탐색
		for (int i = 0; i < 5; i++) {
			answer[i] = searchRoom(places[i]) ? 1 : 0;
		}

		System.out.println(Arrays.toString(answer));
	}

	// 방 탐색
	private static boolean searchRoom(String[] place) {
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {

				// 사람 있는 곳에서 거리두기 확인
				if (place[y].charAt(x) == 'P') {
					if (!checkNear(place, x, y)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	// 바로 인접한 하, 우측 확인 (상, 좌측은 이전 사람을 통해 검사 완료)
	private static boolean checkNear(String[] place, int x, int y) {
		for (int i = 0; i < 2; i++) {
			// 체크할 위치 설정
			int moveX = x + DX[i];
			int moveY = y + DY[i];

			// 범위 넘으면 넘어감
			if (moveX >= 5 || moveY >= 5 ) {
				continue;
			}

			// 바로 인접한 곳에 사람 있으면 false 리턴 (거리 = 1)
			if (place[moveY].charAt(moveX) == 'P') {
				return false;
			}

			// 인접한 곳이 빈 테이블일 시 해당 테이블 인접한 위치에 사람 확인 (거리 = 2)
			if (place[moveY].charAt(moveX) == 'O') {
				// 현재가 우측일시 다음 탐색에서 좌측 이동 필요 X (좌측 이동 = 본인)
				int directionNum = (i == 0) ? 2 : 3;
				if (!checkNextNear(place, moveX, moveY, directionNum)) {
					return false;
				}
			}
		}

		// 거리 두기 완료
		return true;
	}

	// 빈 테이블 주위의 사람 확인
	private static boolean checkNextNear(String[] place, int x, int y, int directionNum) {
		for (int i = 0; i < directionNum; i++) {
			int moveX = x + DX[i];
			int moveY = y + DY[i];

			if (moveX >= 5 || moveY >= 5 || moveX < 0) {
				continue;
			}

			if (place[moveY].charAt(moveX) == 'P') {
				return false;
			}
		}

		return true;
	}
}
```
<br/>

---

### Try 2 - 테스트 성공

- 모든 방향 다 탐색

```java

```import java.util.Arrays;

class Solution {
    
	private static final int[] DX = {1, 0, -1, 0};
	private static final int[] DY = {0, 1, 0, -1};
    
    public int[] solution(String[][] places) {
		int[] answer = new int[5];

		for (int i = 0; i < 5; i++) {
			answer[i] = searchRoom(places[i]) ? 1 : 0;
		}
        
        return answer;
    }
    
	private static boolean searchRoom(String[] place) {
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				if (place[y].charAt(x) == 'P') {
					if (!checkNear(place, x, y)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean checkNear(String[] place, int x, int y) {
		for (int i = 0; i < 4; i++) {
			int moveX = x + DX[i];
			int moveY = y + DY[i];

			if (moveX >= 5 || moveX < 0 || moveY >= 5 || moveY < 0) {
				continue;
			}

			if (place[moveY].charAt(moveX) == 'P') {
				return false;
			}

			if (place[moveY].charAt(moveX) == 'O') {

				for (int j = 0; j < 4; j++) {
					int nextMoveX = moveX + DX[j];
					int nextMoveY = moveY + DY[j];

					if (nextMoveX >= 5 || nextMoveX < 0 || nextMoveY >= 5 || nextMoveY < 0 || (nextMoveX == x && nextMoveY == y)) {
						continue;
					}

					if (place[nextMoveY].charAt(nextMoveX) == 'P') {
						return false;
					}

				}
			}
		}
		return true;
	}
    
}