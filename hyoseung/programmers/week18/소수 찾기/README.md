## 소수 찾기

<br/>

### 책 참조 전 상태의 코드
```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    private Set<Integer> primeNumbers = new HashSet<>();
    
    public int solution(String numbers) {
        permutation("", numbers);
        return primeNumbers.size();
    }
    
    private void permutation(String prefix, String str) {
        int n = str.length();
        if (!prefix.equals("")) {
            int num = Integer.parseInt(prefix);
            if (isPrime(num)) {
                primeNumbers.add(num);
            }
        }
        for (int i = 0; i < n; i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }
    
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
```

### 책 참조 후 상태의 코드
```java
import java.util.*;
import java.util.stream.Collectors;


class Solution {
    
    private boolean isPrime(int n) {
        if(n<=1) return false;
        for(int i=2; i * i<=n; i++) 
            if(n%i == 0) return false;
        
        return true;
    }
    
    private void getPrimes(int acc, int[] numbers, boolean[] isUsed, Set<Integer> primes) {
        if(isPrime(acc)) primes.add(acc);
        
        for(int i = 0; i < numbers.length; i++) {
            if(isUsed[i]) continue;
            
            int nextAcc = acc * 10 + numbers[i];
            
            isUsed[i] = true;
            getPrimes(nextAcc, numbers,isUsed, primes);
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