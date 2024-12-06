# 기능 개발

## 교안 참조 전 상태의 코드

```java
import java.util.*;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            q.add((100 - progresses[i]) % speeds[i] == 0 ?
                    (100 - progresses[i]) / speeds[i] :
                    (100 - progresses[i]) / speeds[i] + 1);
        }

        int x = q.poll();
        int count = 1;
        
        while(!q.isEmpty()) {
            if (x >= q.peek()) {
                count++;
                q.poll();
            } else {
                list.add(count);
                count = 1;
                x = q.poll();
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
}
```

### 문제 풀이

### 1. 변수 초기화
- `ArrayList<Integer> list`: 매번 배포 시 배포되는 작업 수를 저장할 리스트.
- `Queue<Integer> q`: 각 작업의 완료 일수를 저장하는 큐.

<br/>

### 2. 각 작업의 완료 일수 계산
- `for` 루프를 통해 각 작업이 완료되기까지 필요한 일수를 계산하고 그 값을 큐에 추가한다.
- 완료 일수는 `(100 - progresses[i]) / speeds[i]`로 계산되며, 정확히 나누어떨어지지 않는 경우 올림 처리를 위해 `+1`을 추가한다.

    ```java
    for (int i = 0; i < progresses.length; i++) {
        q.add((100 - progresses[i]) % speeds[i] == 0 ? 
              (100 - progresses[i]) / speeds[i] : 
              (100 - progresses[i]) / speeds[i] + 1);
    }
    ```

<br/>

### 3. 배포 일수별 작업 묶음 계산
- `q.poll()`로 첫 번째 작업의 완료 일수를 가져와 `x`로 설정한다.
- `count`는 같은 날 배포할 수 있는 작업 수를 저장하며, 첫 번째 작업이 배포되는 것으로 가정하여 `1`로 초기화한다.
- 큐에 작업이 남아 있는 동안, `peek()`로 다음 작업의 완료 일수를 확인하고 `x`보다 작거나 같다면 배포 가능하므로 `count`를 증가시키고 `poll()`로 제거한다.
- 그렇지 않으면 현재 `count` 값을 `list`에 추가하고, `count`를 `1`로 초기화하여 새로 배포될 작업 수를 기록하며 `x`를 다음 작업의 완료 일수로 업데이트한다.

    ```java
    int x = q.poll();
    int count = 1;
    
    while (!q.isEmpty()) {
        if (x >= q.peek()) {
            count++;
            q.poll();
        } else {
            list.add(count);
            count = 1;
            x = q.poll();
        }
    }
    list.add(count); // 마지막 배포 그룹 추가
    ```

<br/>

### 4. 결과 배열 생성
- `list`에 저장된 배포 횟수를 `int[]` 배열 `answer`로 변환하여 반환한다.

    ```java
    int[] answer = new int[list.size()];
    for (int i = 0; i < answer.length; i++) {
        answer[i] = list.get(i);
    }
  
    return answer;
    ```

<br/>

## 교안 참조 이후 상태의 코드

```java
import java.util.*;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i_++) {
            q.add(i);
        }
        
        List<Integer> result = new ArrayList<>();
        int days = 0;
        int count = 0;
        while(!q.isEmpty()) {
            int index = q.poll();
            int expiration = (int) Math.ceil(
                    (double) (100 - progresses[index] / speeds[index]));
            
            if (expiration > days) {
                if (days != 0) {
                    result.add(count);
                    count = 0;
                }
                days = expiration;
            }
            count++;
        }
        
        result.add(count);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
}
```

### 교안 회고
- 교안의 경우 peek() 메소드를 사용하는 것이 아닌 매 횟수마다 반복시 index를 초기화 하는 것으로 poll()만 사용하는 것과 Stream API를 이용해 결과 배열을 반환하는 것이 최신 Java 기능을 활용하고 있다는 차이점을 느꼈다.