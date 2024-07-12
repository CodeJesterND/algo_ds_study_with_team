## 가장 많이 받은 선물

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 1. 선물 주고받은 횟수 계산
        Map<String, Integer> giftCounts = new HashMap<>();
        for (String gift : gifts) {
            String[] temp = gift.split(" ");
            String giver = temp[0];
            String receiver = temp[1];
            String key = giver + "," + receiver;
            giftCounts.put(key, giftCounts.getOrDefault(key, 0) + 1);
        }

        // 2. 선물 지수 계산
        Map<String, Integer> giftIndex = new HashMap<>();
        for (String friend : friends) {
            giftIndex.put(friend, 0);
        }

        for (String key : giftCounts.keySet()) {
            String[] temp = key.split(",");
            String giver = temp[0];
            String receiver = temp[1];
            int count = giftCounts.get(key);
            giftIndex.put(giver, giftIndex.get(giver) - count);
            giftIndex.put(receiver, giftIndex.get(receiver) + count);
        }

        // 3. 다음 달 받을 선물 계산
        Map<String, Integer> nextMonthGifts = new HashMap<>();
        for (String friend : friends) {
            nextMonthGifts.put(friend, 0);
        }
        for (String friend1 : friends) {
            for (String friend2 : friends) {
                if (friend1.equals(friend2)) {
                    continue;
                }
                int give1to2 = giftCounts.getOrDefault(friend1 + "," + friend2, 0);
                int give2to1 = giftCounts.getOrDefault(friend2 + "," + friend1, 0);
                if (give1to2 > give2to1) {
                    nextMonthGifts.put(friend1, nextMonthGifts.get(friend1) + 1);
                } else if (give1to2 == give2to1 && giftIndex.get(friend1) < giftIndex.get(friend2)) {
                    nextMonthGifts.put(friend1, nextMonthGifts.get(friend1) + 1);
                }
            }
        }

        // 4. 가장 많이 받는 선물 수 반환
        int maxGifts = 0;
        for (int giftCount : nextMonthGifts.values()) {
            maxGifts = Math.max(maxGifts, giftCount);
        }
        return maxGifts;
    }
}
```

* `giftCounts` 맵을 사용하여 각 친구 쌍이 선물을 주고받은 횟수를 저장한다.
* `giftIndex` 맵을 사용하여 각 친구의 선물 지수를 계산한다.
* 선물 지수는 준 선물 수와 받은 선물 수의 차이를 나타낸다
* `nextMonthGifts` 맵을 사용하여 각 친구가 다음 달에 받을 선물 수를 계산한다.
* 선물 횟수가 더 많거나, 같을 경우 선물 지수가 낮은 친구에게 선물을 받도록 예측한다.
* `nextMonthGifts` 맵에서 가장 큰 값을 찾아 반환한다.
