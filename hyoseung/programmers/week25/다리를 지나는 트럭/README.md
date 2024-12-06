# 다리를 지나는 트럭

## 교안 참조 전 상태의 코드

```java
import java.util.*;

class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < bridge_length - 1; i++) {
            q.add(0);
        }
        
        int current_w = truck_weights[0]; 
        q.add(current_w);
        
        int answer = 1;
        int index = 1;
        
        while(!q.isEmpty()) {
            answer++;
            
            int removed = q.poll();
            current_w -= removed;
            
            if (index < truck_weights.length) {
                if (current_w + truck_weights[index] <= weight) {
                    current_w += truck_weights[index];
                    q.add(truck_weights[index]);
                    index++;
                } else {
                    q.add(0);
                }
            }
        }
        
        return answer; 
    }
    
}
```

### 문제 풀이

### 1. 큐 초기화
- 다리를 나타내는 큐를 사용하여 다리의 현재 상태를 관리한다.
- 큐의 초기 크기는 `bridge_length - 1`만큼 0으로 채운다.

    ```java
    Queue<Integer> q = new LinkedList<>();
    
    for (int i = 0; i < bridge_length - 1; i++) {
        q.add(0);
    }
    ```

<br/>

### 2. 첫 번째 트럭 올리기
- 첫 번째 트럭을 다리 위에 올리기 위해 큐에 추가하고, 현재 다리에 있는 트럭의 무게를 `current_w`에 저장하며, 시간은 1로 초기화한다.

    ```java
    int current_w = truck_weights[0]; 
    q.add(current_w);
    
    int answer = 1; // 시간 1부터 시작
    int index = 1; // 다음 트럭 인덱스
    ```

<br/>


### 3. 다리 위에서 트럭 이동 처리
- 큐가 비어 있지 않은 동안 반복하여 트럭의 이동을 처리한다. 
- 각 반복에서 시간을 증가시키고, 큐에서 제거된 트럭의 무게를 현재 무게에서 뺀다.

    ```java
    while (!q.isEmpty()) {
        answer++; // 시간 증가
        
        int removed = q.poll(); // 다리에서 나가는 트럭 제거
        current_w -= removed; // 현재 무게 갱신
    ```

<br/>

### 4. 다음 트럭 추가
- 남은 트럭이 있는 경우 다리에 새로 올라갈 트럭의 무게를 현재 다리의 무게와 비교하여 추가할 수 있는지 판단한다. 
- 추가할 수 있다면 트럭을 큐에 추가하고, 인덱스를 증가시킨다. 
- 추가할 수 없을 경우, 큐에 0을 추가하여 공간을 유지한다.

    ```java
    if (index < truck_weights.length) {
        if (current_w + truck_weights[index] <= weight) {
            current_w += truck_weights[index]; // 무게 업데이트
            q.add(truck_weights[index]); // 큐에 트럭 추가
            index++; // 다음 트럭으로 이동
        } else {
            q.add(0); // 공간 유지
        }
    }
    ```

<br/>

### 5. 결과 반환
- 모든 트럭이 다리를 건너는 데 걸린 총 시간을 반환한다.

    ```java
    return answer; 
    ```

<br/>

## 교안 참조 이후 상태의 코드

```java
import java.util.*;

class Solution {
    
    public int[] solution(int bridge_length, int weight, int[] truck_weights) {
        int bridgeWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();
        
        for (int i = 0; i < bridgeLength; i++) {
            bridge.add(0);
        }
        
        int time = 0;
        int truckIndex = 0;
        while (truckIndex < truckWeights.length) {
            bridgeWeight -= bridge.poll();
            int truckWeight = truckWeights[truckIndex];
            if (bridgeWeight + truckWeight <= weight) {
                bridge.add(truckWeight);
                bridgeWeight += truckWeight;
                truckIndex++;
            } else {
                bridge.add(0);
            }
            time++;
        }
        
        while (bridgeWeight > 0) {
            bridgeWeight -= bridge.poll();
            time++;
        }
        
        return time;
    }
    
}
```

### 교안 회고
- 첫번째 코드의 경우 트럭이 현재 다리에 올라갈 있는지에 집중되었다면, 교안의 경우 모든 트럭이 지나간 후에도 큐에서 남아있는 트럭이 있는지 검증 후 처리하는 것이 크게 와닿았다.
- 과정만 집중하는 것이 아닌 결과 진행 방향에 대해서도 생각해볼 필요성을 느낀 문제이다.