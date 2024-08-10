## 쿼드압축 후 개수 세기

<br>

### 책 참조 전 상태의 코드
```java
class Solution {
    int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        int totalSize = arr.length; // 배열의 크기 (NxN 정사각형 형태)
        divideConquer(0, 0, totalSize, arr); // 재귀 함수 호출 시작
        return answer;
    }

    private void divideConquer(int startX, int startY, int size, int[][] arr) {
        if (check(startX, startY, size, arr)) { // 주어진 영역이 모두 같은 숫자인지 확인
            answer[arr[startX][startY]]++; // 해당 숫자 카운트 증가
            return; // 모두 같은 숫자이면 더 이상 분할할 필요 없음
        }

        int halfSize = size / 2; // 4개의 작은 영역으로 분할하여 재귀 호출

        divideConquer(startX, startY, halfSize, arr); // 좌상단
        divideConquer(startX + halfSize, startY, halfSize, arr); // 우상단
        divideConquer(startX, startY + halfSize, halfSize, arr); // 좌하단
        divideConquer(startX + halfSize, startY + halfSize, halfSize, arr); // 우하단
    }

    private boolean check(int x, int y, int size, int[][] arr) {
        int value = arr[x][y]; // 시작점
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false; // 시작점의 값과 다르면 false 반환
                }
            }
        }
        return true;
    }
}
```

<br>

### 책 참조 후 상태의 코드
```java
public class Solution {
  private static class Count {
      public final int zero;
      public final int one;
      
      public Count(int zero, int one) {
          this.zero;
          this.one;
      }
      
      public Count add(Count other) {
          return new Count(zero + other.zero, one + other.one);
      }
  }
}
```