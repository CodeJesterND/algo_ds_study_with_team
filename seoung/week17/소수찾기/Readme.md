# [소수찾기](https://school.programmers.co.kr/learn/courses/30/lessons/42839)


1. dfs를 사용하여 모든 숫자를 조합
2. isPrime 소수 찾기 function 구현

```
import java.util.*;



class Solution {
    static int count = 0;
    static boolean[] visited;
    
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        visited = new boolean[numbers.length()];
        
        dfs(numbers, "", 0);
        
        for(Integer num : set) {
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    
    public void dfs(String numbers, String s,int depth) {
        
        if(depth > numbers.length()) return ;
        
        for(int i=0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers, s + numbers.charAt(i), depth+1);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if(n < 2) return false;
        
        for(int i = 2; i <= (int)Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        
        return true;
    }
}
```

## 책 문제 풀이


```
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