## 두 개 뽑아서 더하기 

1. 체크를 해주기 위한 배열을 만들어주었다. 100 + 99 를 더해준다고 가정했을 때, 200을 선언해도 충분하다.

2. 이중 포문을 돌면서 각각의 경우의 수를 더해주어 flag 를 태워서 flag true를 만들어준다.

3. Collections.sort를 사용해여. list를 정렬해준다. 그 후, list 반환. 

```
import java.util.*;

class Solution {
    public List<Integer> solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        boolean []flag = new boolean[200];
        for(int i=0; i< numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                int num = numbers[i] + numbers[j];
                if(!flag[num]) {
                    list.add(num);    
                    flag[num] = true;
                }
                
            }
        }
        Collections.sort(list);   
        return list;
    }
}
```

파이썬 문제 풀이

```
def solution(numbers):
    answer = []
    index=0
    for i in range(len(numbers)):
        for j in range (i+1, len(numbers)):
            if numbers[i] + numbers[j] not in answer:
                answer.append(numbers[i] + numbers[j])
    
    answer.sort();
    return answer
```

range를 통해서 반복문을 돌았다.

if문을 통해서 numbers[i] + numbers[j]가 answer에 포함되어 있지 않다면 배열에 넣어주었다.

그 후, sort 해주었다

```
def solution(numbers):
    answer = set()
    index=0
    for i in range(len(numbers)):
        for j in range (i+1, len(numbers)):
            answer.add(numbers[i] + numbers[j])
    
    answer = list(answer)
    answer.sort();
    return answer
```