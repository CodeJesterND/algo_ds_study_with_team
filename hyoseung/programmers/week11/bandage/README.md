## 붕대 감기

```java
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        Map<Integer, Integer> attackInfo = new HashMap<>();
        int currentHealth = health;
        int successTime = 0; // 초당 회복량 측정..!

        for (int[] attack : attacks) {
            attackInfo.put(attack[0], attack[1]);
        }

        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            if (attackInfo.containsKey(i)) { // 공격 시간 = 현재 시간 같은 경우 마이너스
                currentHealth -= attackInfo.get(i);
                successTime = 0; // 성공 시간 초기화
            } else {
                currentHealth += bandage[1]; // 매 초마다 체력 회복
                successTime++;

                if (successTime == bandage[0]) { // 시전 시간 만족시..!
                    currentHealth += bandage[2];
                    successTime = 0;
                }

                if (currentHealth > health) { // 최대 체력 초과하지 않도록...!
                    currentHealth = health;
                }
            }
            if (currentHealth <= 0) { // 0과 -1 처리
                return -1;
            }
        }

        return answer = currentHealth;
    }
}
```

* `attacks` 배열을 순회하면서 공격 시간과 공격량을 `attackInfo` 맵에 저장합니다.
* 1부터 마지막 공격 시간까지 반복하면서 체력을 계산한다.
* 현재 시간에 공격이 있는지 확인하고 있으면 체력을 감소시킨다.
* 공격이 없는 경우 매 초마다 `bandage[1]` 만큼 체력을 회복하고, `successTime` 을 증가시킨다.
* `successTime` 이 `bandage[0]` 과 같아지면 회복 스킬을 발동하여 추가 체력을 회복하고 `successTime` 을 초기화한다.
* 체력이 최대 체력 `health` 를 초과하지 않도록 조정한다.
* 체력이 0 이하가 되면 -1을 반환하고 종료한다.
* 시뮬레이션이 끝난 후 현재 체력 `currentHealth` 를 반환한다.