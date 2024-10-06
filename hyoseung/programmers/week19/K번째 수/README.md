## K번째 수

<br/>

### 책 참조 전 상태의 코드
```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
                .mapToInt(command -> {
                    int[] subArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
                    Arrays.sort(subArray);
                    return subArray[command[2] - 1];
                })
                .toArray();
    }
}
```

<br/>

### 책 참조 후 상태의 코드
```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < answer.length; i++) {
            int[] command = commands[i];
            int from = command[0] - 1;  
            int to = command[1];       
            int k = command[2] - 1;     

            int[] sub = Arrays.copyOfRange(array, from, to);
            Arrays.sort(sub);
            answer[i] = sub[k];
        }

        return answer;
    }
}
```