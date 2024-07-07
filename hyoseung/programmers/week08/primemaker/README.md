## 소수 만들기

```java
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
        
    private boolean isPrime(int num){
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    } 
}
```

* 세 개의 숫자를 선택하기 위해 세 번의 반복문을 사용하여 모든 가능한 조합을 생성한다.
* 선택된 세 숫자의 합을 계산하고, 해당 합이 소수인지를 확인하는 isPrime 메서드를 호출한다.
* 만약 합이 소수라면 카운트를 증가시킨다.
* 마지막으로 세 개의 숫자를 선택하여 만들어진 소수의 개수를 반환한다.