## [link](https://school.programmers.co.kr/learn/courses/30/lessons/250137)

## 붕대 감기 - 문제 풀이

```
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int life = health;
        int attackIdx = 0;
        int heal = 0;
        for (int i = 1; i <= attacks[attacks.length-1][0]; i++){
            if (i != attacks[attackIdx][0]){
                life += bandage[1];
                heal++;
                if (heal == bandage[0]){
                    life += bandage[2];
                    heal = 0;
                }
                if (life > health) life = health;
            } else {
                heal = 0;
                life -= attacks[attackIdx][1];
                attackIdx++;
                if (life <= 0) return -1;
            }
        }
        return life;
    }
}
```

1. 맨마지막 위치에 -1 한 것이 최종 공격이고 해당 부분까지만 for문을 반복 시켜준다. 
2. if (i != attacks[attackIdx][0]) 공격을 당하지 않았다면 if문을 들어옴 life에 bandage[1] 을 더해준다. bandage는 최당 회복량이기에 life를 증가시킨다. 
3.  if (heal == bandage[0]) heal이 bandage 연속 힐량 시간이랑 똑같으면 life를 증가 및 heal = 0으로 초기화시켜준다.
4. if (life > health) life = health 치유 되었을 때, life보다 크다면 life를 health로 대입시켜줌
5. 그 밖이라면 heal=0 life에 공격력 만큼 줄이고 attackIdx를 한칸 증가 시킨다. 
6. life가 0이나 0보다 작다면 -1을 반환한다.