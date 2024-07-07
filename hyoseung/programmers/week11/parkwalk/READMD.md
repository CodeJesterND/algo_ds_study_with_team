## 공원 산책

```java
import java.util.Arrays;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int row = 0;
        int col = 0;
        int height = park.length;
        int width = park[0].length();

        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                row = i;
                col = park[i].indexOf("S");
                break;
            }
        }

        for (String route : routes) {
            String[] temp = route.split(" ");
            String vector = temp[0]; // 방향
            int distance = Integer.parseInt(temp[1]); // 거리

            int currentRow = row;
            int currentCol = col;

            boolean flag = true;
            switch (vector) {
                case "E": // 동쪽
                    for (int j = 1; j <= distance; j++) {
                        currentCol++;
                        if (currentCol >= width || park[currentRow].charAt(currentCol) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        col = currentCol;
                    }
                    break;
                case "W": // 서쪽
                    for (int j = 1; j <= distance; j++) {
                        currentCol--;
                        if (currentCol < 0 || park[currentRow].charAt(currentCol) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        col = currentCol;
                    }
                    break;
                case "N": // 북쪽
                    for (int j = 1; j <= distance; j++) {
                        currentRow--;
                        if(currentRow < 0 || park[currentRow].charAt(currentCol) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        row = currentRow;
                    }
                    break;
                case "S": // 남쪽
                    for (int j = 1; j <= distance; j++) {
                        currentRow++;
                        if(currentRow >= height || park[currentRow].charAt(currentCol) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        row = currentRow;
                    }
                    break;
            }
        }

        answer[0] = row;
        answer[1] = col;

        return answer;
    }
}
```

* 좌표 `answer` 배열을 생성하여 최종 위치를 저장할 준비한다.
* `row` 와 `col` 변수는 출발점 'S' 의 위치를 저장한다.
* `height` 와 `width` 변수는 공원의 세로 길이와 가로 길이를 저장한다.
* `park` 배열을 순회하면서 'S'가 있는 위치를 찾아 `row` 와 `col` 에 저장한다.
* `routes` 배열을 순회하면서 각 경로를 처리한다.
* 각 경로는 방향과 거리로 이루어져 있으며, 이를 분리하여 `vector` 와 `distance` 로 저장한다.
* 방향에 따라 `E`, `W`, `S`, `N` 으로 나누어 현재 위치에서 주어진 거리를 이동한다.
* 이동 중에 범위를 벗어나거나 장애물 'X'에 부딪히면 이동을 중단하고, `flag` 를 `false` 로 설정한다.
* 이동이 성공적이면 `row` 와 `col` 값을 업데이트한다.
* 최종 위치를 `answer` 배열에 저장하고 반환한다.
* 이 코드는 경로를 따라 이동하면서 범위와 장애물을 체크하여 최종 위치를 계산하는 로직을 구현한다.