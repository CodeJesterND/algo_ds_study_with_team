## 바탕화면 정리

```java
class Solution {
    public int[] solution(String[] wallpaper) {

        int minRow, minCol;
        int maxRow, maxCol;

        minRow = minCol = Integer.MAX_VALUE;
        maxRow = maxCol = Integer.MIN_VALUE;

        int row = wallpaper.length;
        int col = wallpaper[0].length();

        for (int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                if (wallpaper[r].charAt(c) == '#') { // 첫번째 #을 기준으로 행과 열을 비교..!
                    minRow = Math.min(minRow, r);
                    minCol = Math.min(minCol, c);
                    maxRow = Math.max(maxRow, r);
                    maxCol = Math.max(maxCol, c);
                }
            }
        }

        return new int[]{minRow, minCol, maxRow + 1, maxCol + 1};
    }
}
```

* `minRow`, `minCol`, `maxRow`, `maxCol`을 각각 `Integer.MAX_VALUE`, `Integer.MIN_VALUE` 로 초기화한다. 
* 이중 반복문을 사용하여 `wallpaper` 배열을 탐색한다.
* 각 위치에서 '#' 문자를 발견하면 해당 위치의 행과 열 값을 `minRow`, `minCol`, `maxRow`, `maxCol` 과 비교하여 초기화한다.
* 배열의 모든 요소를 탐색한 후에는 `minRow`, `minCol` 은 최소값을, `maxRow + 1`, `maxCol + 1`은 최대값에 1을 더한 값을 반환한다.