[프로그래머스 - 소수 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/42839)

---

### 내 풀이
```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
        int[] nums = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            nums[i] = numbers.charAt(i) - '0';
        }

        Set<Integer> primes = new HashSet<>();
        findPrimes(nums, 0, new boolean[nums.length], primes);
        return primes.size();
    }
    
    private static void findPrimes(int[] nums, int currentNum, boolean[] used, Set<Integer> primes) {
        if (isPrime(currentNum)) {
            primes.add(currentNum);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                findPrimes(nums, currentNum * 10 + nums[i], used, primes);
                used[i] = false;
            }
        }
    }

    private static boolean isPrime(int currentNum) {
        if (currentNum < 2) {
            return false;
        }

        for (int i = 2; i * i <= currentNum; i++) {
            if (currentNum % i == 0) {
                return false;
            }
        }
        return true;
    }
}
```

<br/>

---

### 교재 풀이

```java
import java.util.HashSet;
import java.util.Set;

public class Solution {
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private void getPrimes(int acc, int[] numbers, boolean[] isUsed,
                           Set<Integer> primes) {
        if (isPrime(acc)) primes.add(acc);

        for (int i = 0; i < numbers.length; i++) {
            if (isUsed[i]) continue;

            int nextAcc = acc * 10 + numbers[i];

            isUsed[i] = true;
            getPrimes(nextAcc, numbers, isUsed, primes);
            isUsed[i] = false;
        }
    }

    public int solution(String nums) {
        Set<Integer> primes = new HashSet<>();
        int[] numbers = nums.chars().map(c -> c - '0').toArray();
        getPrimes(0, numbers, new boolean[numbers.length], primes);
        return primes.size();
    }
}
```

