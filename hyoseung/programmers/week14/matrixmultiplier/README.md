## 행렬의 곱셈

```java
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[i].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
```

* `answer` 배열을 생성하여 결과 행렬을 저장할 공간을 확보한다.
* 크기는 `arr1`의 행 개수와 `arr2`의 열 개수로 결정된다.
* 삼중 반복문을 사용하여 행렬 곱셈을 수행한다.
* 첫 번째 반복문 `arr1`의 행을 순회한다.
* 두 번째 반복문 `arr2`의 열을 순회한다.
* 세 번째 반복문 `arr1`의 행과 `arr2`의 열의 요소들을 곱하고 누적하여 `answer[i][j]`에 저장한다.
* 계산된 행렬 `answer`를 반환한다.