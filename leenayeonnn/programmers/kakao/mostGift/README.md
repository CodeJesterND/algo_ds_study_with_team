[프로그래머스 - 가장많이받은선물](https://school.programmers.co.kr/learn/courses/30/lessons/258712)

---
## 아이디어
 1. 테이블로 선물 내역 정리
	 - row = 준사람
	 - col = 받은 사람 
	 - 순서는 배열 순서 그대로    
 2. 표를 통해서 다음 달 선물 예상

</br>

```java
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public int solution(String[] friends, String[] gifts) {
		int friendLen = friends.length;
		int[][] giftTable = new int[friendLen][friendLen];
		int[] giftScore = new int[friendLen];

		for (String gift : gifts) {
			StringTokenizer stringTokenizer = new StringTokenizer(gift);
			String giver = stringTokenizer.nextToken();
			String taker = stringTokenizer.nextToken();

			int x = Arrays.asList(friends).indexOf(taker);
			int y = Arrays.asList(friends).indexOf(giver);

			giftTable[y][x]++;
			giftScore[y]++;
			giftScore[x]--;
		}

		int[] nextGifts = new int[friendLen];
		for (int i = 0; i < friendLen; i++) {
			for (int j = i + 1; j < friendLen; j++) {
				if (i == j) {
					continue;
				}

				if (giftTable[i][j] > giftTable[j][i]) {
					nextGifts[i]++;
				} else if (giftTable[i][j] < giftTable[j][i]) {
					nextGifts[j]++;
				} else {
					if(giftScore[i] > giftScore[j]) {
						nextGifts[i]++;
					} else if(giftScore[i] < giftScore[j]) {
						nextGifts[j]++;
					}
				}
			}

		}

		return Arrays.stream(nextGifts).max().getAsInt();
    }
}
```