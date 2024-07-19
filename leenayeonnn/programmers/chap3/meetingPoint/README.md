[프로그래머스 - 교점에 별 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/87377)

---
<br/>

- ❗교점의 좌표가 int 범위 이상 이슈!! => long 타입으로 변경

- ✔️ 교재 해설 확인
    - Point 객체 만들어서 좌표 정보 저장
    - 배열이 아닌 List 사용
    - 교점을 다 구한 후 최대, 최소 좌표 계산

<br/>

---

<br/>

```java
import java.util.Arrays;

class Solution {
    	public String[] solution(int[][] line) {

		Long[][] points = new Long[line.length * (line.length - 1) / 2][2];
		int cnt = 0;

        // 결과 좌표판 최소 범위를 위한 정보 저장
		Long[] maxPoint = {Long.MIN_VALUE, Long.MIN_VALUE};
		Long[] minPoint = {Long.MAX_VALUE, Long.MAX_VALUE};

        // 교점 확인
		for (int i = 0; i < line.length - 1; i++) {
			for (int j = i + 1; j < line.length; j++) {

                // 계수 저장
				long a = line[i][0];
				long b = line[i][1];
				long e = line[i][2];
				long c = line[j][0];
				long d = line[j][1];
				long f = line[j][2];

                // 분모 0 확인
				long denominator = a * d - b * c;
				if (denominator == 0) {
					continue;
				}

                // 좌표 분자값 계산
				long x = b * f - e * d;
				long y = e * c - a * f;

                // 좌표값이 정수인지 확인
				if (x % denominator != 0 || y % denominator != 0) {
					continue;
				}

				// 좌표 저장
                x /= denominator;
				y /= denominator;
				points[cnt][0] = x;
				points[cnt++][1] = y;

				//좌표 최대, 최소 확인
                checkMaxPoint(maxPoint, x, y);
				checkMinPoint(minPoint, x, y);
			}
		}

		// 결과 좌표판 크기 설정
        int xLen = (int)(maxPoint[0] - minPoint[0] + 1);
		int yLen = (int)(maxPoint[1] - minPoint[1] + 1);

		char[][] board = new char[yLen][xLen];
		Arrays.stream(board).forEach(row -> Arrays.fill(row, '.'));

		// 교점 지점에 별 찍기
        for (int i = 0; i < cnt; i++) {
			int x = (int)(points[i][0] - minPoint[0]);
			int y = (int)(maxPoint[1] - points[i][1]);
			board[y][x] = '*';
		}

		String[] answer = new String[yLen];
		for (int i = 0; i < yLen; i++) {
			answer[i] = new String(board[i]);
		}

        return answer;
	}

	private static void checkMaxPoint(Long[] maxPoint, long x, long y) {
		if (x > maxPoint[0]) {
			maxPoint[0] = x;
		}

		if (y > maxPoint[1]) {
			maxPoint[1] = y;
		}
	}

	private static void checkMinPoint(Long[] minPoint, long x, long y) {
		if (x < minPoint[0]) {
			minPoint[0] = x;
		}
		if (y < minPoint[1]) {
			minPoint[1] = y;
		}
	}
}
```