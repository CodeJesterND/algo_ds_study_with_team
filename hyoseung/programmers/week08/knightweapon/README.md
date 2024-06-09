## 기사단원의 무기

```java
class Solution {
    public int solution(int number, int limit, int power) {
        int totalWeight = 0;

        for(int i = 1; i <= number; i++) {
            int weaponCount = countFactors(i);
            if (weaponCount > limit) {
                totalWeight += power;
            } else {
                totalWeight += weaponCount;
            }
        }
        return totalWeight;
    }

    public int countFactors(int num) {
        int count = 0;
        for(int i = 1; i <= num / 2; i++) {
            if(num % i == 0) {
                count++;
            }
        }
        return count + 1;
    }
}
```