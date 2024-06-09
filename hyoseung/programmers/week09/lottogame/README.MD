## 로또의 최고 순위와 최저 순위

```java
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount =  0;
        int matchCount = 0;

        for (int num : lottos) {
            if (num == 0) {
                zeroCount++;
            }
        }

        zeroCount = (int) Arrays.stream(lottos).filter(lotto -> lotto == 0).count();

        List<Integer> list = Arrays.asList(win_nums);

        for (int num : lottos) {
            if (list.contains(num)) {
                matchCount++;
            }
        }

        int dreamNum = matchCount + zeroCount;
        int realNum = matchCount;

        int[] result = new int[2];
        result[0] = getRank(dreamNum);
        result[1] = getRank(realNum);

        return result;
    }

    int getRank(int match) {
        switch (match) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
```