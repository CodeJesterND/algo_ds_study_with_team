[프로그래머스 - 행렬의 곱셈](https://school.programmers.co.kr/learn/courses/30/lessons/12949)


---

<br/>

```java
// 단순 행렬 계산
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 행렬1 세로 = 결과 세로 / 행렬2 가로 = 결과 가로
        int[][] answer = new int[arr1.length][arr2[0].length];

		for (int row1 = 0; row1 < arr1.length; row1++) {
			for (int col1 = 0; col1 < arr1[row1].length; col1++) {
				for (int col2 = 0; col2 < arr2[0].length; col2++) {
					answer[row1][col2] += arr1[row1][col1] * arr2[col1][col2];
				}
			}
		}
        
        return answer;
    }
}
```