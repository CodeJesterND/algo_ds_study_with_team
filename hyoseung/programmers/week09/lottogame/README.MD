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

* 주어진 로또 번호 배열에서 0의 개수를 세어 `zeroCount` 변수에 저장한다.
* 주어진 로또 번호 배열과 당첨 번호 배열을 비교하여 일치하는 번호의 개수를 세어 `matchCount` 변수에 저장한다.
* 최고 순위의 경우, 0의 개수와 일치하는 번호의 개수를 합산하여 `dreamNum`에 저장한다.
* 최저 순위의 경우, 일치하는 번호의 개수만을 `realNum`에 저장한다.
* `getRank` 함수를 사용하여 `dreamNum`과 `realNum`에 대한 등수를 계산하여 배열에 저장한다.
* 계산된 등수를 포함한 배열을 반환한다.