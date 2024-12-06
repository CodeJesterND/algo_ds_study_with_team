# 등굣길

## 교안 참조 전 상태의 코드

```java
public class Solution {
  public int solution(int m, int n, int[][] puddles) {
    int[][] dp = new int[n + 1][m + 1];
    int mod = 1_000_000_007;

    // 웅덩이 위치를 0으로 설정
    for (int[] puddle : puddles) {
      dp[puddle[1]][puddle[0]] = 0;
    }

    // 시작점 초기화
    dp[1][1] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (dp[i][j] == 0) {  // 웅덩이는 건너뜀
          continue;
        }
        // 위쪽 경로에서 오는 경우
        if (i > 1) {
          dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
        }
        // 왼쪽 경로에서 오는 경우
        if (j > 1) {
          dp[i][j] = (dp[i][j] + dp[i][j - 1]) % mod;
        }
      }
    }

    return dp[n][m];
  }
}
```

<br/>

## 교안 참조 이후 상태의 코드

```java

```