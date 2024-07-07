## 옹알이

```java
class Solution {
    public int solution(String[] babbling) {

        int answer = 0; 
        
        for(int i=0; i<babbling.length; i++){

            if(babbling[i].contains("ayaaya") 
               || babbling[i].contains("yeye") 
               || babbling[i].contains("woowoo")
               || babbling[i].contains("mama")){
                continue;
            }
            
            babbling[i] = babbling[i].replace("aya", " ");
            babbling[i] = babbling[i].replace("ye", " ");
            babbling[i] = babbling[i].replace("woo", " ");
            babbling[i] = babbling[i].replace("ma", " ");
            babbling[i] = babbling[i].replace(" ", "");

            if(babbling[i].isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}
```

* `babbling` 배열의 각 요소를 순회하면서 특정 패턴을 가진 문자열을 걸러낸다.
* 걸러진 문자열은 해당 패턴들을 공백으로 대체한 후, 공백을 제거하여 빈 문자열인지 확인한다.
* 빈 문자열인 경우에는 카운트를 증가시킨다.
* 마지막으로 카운트된 값을 반환한다.