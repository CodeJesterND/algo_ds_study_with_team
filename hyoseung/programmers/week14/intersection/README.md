## 교점에 별 만들기

```java
import java.util.*;

class Solution {
    public String[] solution(int[][] line) {

        class Point {
            long x, y;

            private Point(long x, long y) {
                this.x = x;
                this.y = y;
            }
        }

        int startX = Integer.MAX_VALUE;
        int startY = Integer.MAX_VALUE;
        int endX = Integer.MIN_VALUE;
        int endY = Integer.MIN_VALUE;

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];

                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long denominator = (a * d) - (b * c);
                if (denominator == 0) continue;

                long isValidInt1 = (b * f) - (e * d);
                long isValidInt2 = (e * c) - (a * f);
                if (isValidInt1 % denominator != 0 || isValidInt2 % denominator != 0) {
                    continue;
                }

                Point point = new Point(isValidInt1 / denominator, isValidInt2 / denominator);

                if (!points.contains(point)) {
                    points.add(point);
                }

                startX = Math.min(startX, (int) point.x);
                startY = Math.min(startY, (int) point.y);
                endX = Math.max(endX, (int) point.x);
                endY = Math.max(endY, (int) point.y);
            }
        }

        List<String> board = new ArrayList<>();
        for (int i = startY; i <= endY; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = startX; j <= endX; j++) {
                sb.append(".");
            }
            board.add(sb.toString());
        }

        for (Point point : points) {
            int x = (int) Math.abs(point.x - startX);
            int y = (int) Math.abs(point.y - startY);

            StringBuilder sb = new StringBuilder(board.get(y));
            sb.setCharAt(x, '*');
            board.set(y, sb.toString());
        }

        String[] answer = new String[board.size()];
        for (int i = 0; i < board.size(); i++) {
            answer[i] = board.get(board.size() - i - 1);
        }

        return answer;
    }
}
```

* `Point 클래스`: 좌표 평면에서의 점을 나타내는 x와 y 좌표를 저장한다.
* line 배열의 각 행은 하나의 직선의 계수 `a, b, c`를 나타낸다.
* `startX`, `startY`, `endX`, `endY` 변수를 초기화하여 별 지도의 경계를 추적한다.
* 교점을 저장할 빈 리스트 `points`를 생성한다.
* 중첩 반복문을 사용하여 모든 직선 쌍을 검사한다.
* 각 직선 쌍에 대해 행렬식 `denominator`을 계산한다.
* 행렬식이 0이면 두 직선은 평행하거나 일치하므로 교점이 없기에 건너뛴다.
* 크래머 공식을 사용하여 교점의 x, y 좌표를 계산한다.
* 만약 좌표가 정수가 아니라면, 교점이 격자점 위에 있지 않으므로 건너뛴다.
* 유효한 교점이라면 `points` 리스트에 추가하고, 필요에 따라 별 지도의 경계를 업데이트한다.
* 별 지도를 나타내는 `board` 리스트를 생성한다.
* 각 요소는 초기에 점(.)으로 채워진 문자열로, 빈 공간을 나타낸다.
* points 리스트에 저장된 교점들을 순회합니다.
* 각 교점에 대해, `board`에서 해당하는 x, y 좌표를 계산한다.
* 해당 위치의 문자를 `.`에서 `*`로 변경하여 별을 표시한다.
* 최종적으로 `board`를 뒤집어 별 지도의 위쪽 방향을 올바르게 설정한다.
* 별 지도를 문자열 배열 형태로 변환하여 반환한다.