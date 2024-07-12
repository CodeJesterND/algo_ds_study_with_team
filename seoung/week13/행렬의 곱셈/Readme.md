# [link](https://school.programmers.co.kr/learn/courses/30/lessons/12949)


## 내가 푼 문제 풀이

```
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2[0].length; j++){
                int temp=0;
                for(int z=0; z<arr2.length; z++){
                    temp += arr1[i][z] * arr2[z][j];
                }
                answer[i][j] = temp;
            }
        }
        return answer;
    }
}
```