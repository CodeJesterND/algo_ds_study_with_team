[프로그래머스 - 쿼드압축 후 개수 세기](https://school.programmers.co.kr/learn/courses/30/lessons/68936)

---

### 내 풀이
```java
class Solution {
    public int[] solution(int[][] arr) {
        // 재귀 시작
        int[] answer = compression(arr, 0, 0, arr.length);;
        return answer;
    }
    
    // (X,Y) 를 시작점으로 len 크기의 정사각형 탐색
    private static int[] compression(int[][] arr, int x, int y, int len) {
		int base = arr[y][x];
		for (int i = y; i < y + len; i++) {
			for (int j = x; j < x + len; j++) {
				if (arr[i][j] != base) {
					int[] leftTop = compression(arr, x, y, len / 2);
					int[] rightTop = compression(arr, x + len / 2, y, len / 2);
					int[] leftBottom = compression(arr, x, y + len / 2, len / 2);
					int[] rightBottom = compression(arr, x + len / 2, y + len / 2, len / 2);

					int[] result = new int[2];
					result[0] = leftTop[0] + rightTop[0] + leftBottom[0] + rightBottom[0];
					result[1] = leftTop[1] + rightTop[1] + leftBottom[1] + rightBottom[1];
					return result;
				}
			}
		}

		return base == 0 ? new int[] {1, 0} : new int[] {0, 1};
	}
}
```

<br/>

---

### 교재 풀이

```java
public class Solution {
    private static class Count {
        public final int zero;
        public final int one;

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other) {
            return new Count(zero + other.zero, one + other.one);
        }
    }

    private Count count(int offsetX, int offsetY, int size,
                        int[][] arr) {
        int h = size / 2;
        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    return count(offsetX, offsetY, h, arr)
                            .add(count(offsetX + h, offsetY, h, arr))
                            .add(count(offsetX, offsetY + h, h, arr))
                            .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }

        if (arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }
        return new Count(1, 0);
    }

    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[] {count.zero, count.one};
    }
}
```

