## K번째 수 

```
import java.util.*;

class solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int targetNum = commands[i][2];
            
            int []clone = Arrays.copyOfRange(array, start-1, end);
            
            Arrays.sort(clone);
            answer[i] = clone[targetNum - 1];
        }
        
        return answer;
    }
```
1. commands [i][0]에서 start를 가져온다.
2. commands [i][1]에서 end를 가져옴.


Arrays.copyOfRange(array, start-1, end)를 통해서 배열을 복사해.
Arrays.sort를 통해서 정렬해준다. 

```
def solution(array, commands):
    answer = []
    for i in range(len(commands)) :
        arr = array[commands[i][0]-1:commands[i][1]]
        arr.sort();
        answer.append(arr[commands[i][2]-1]);
    return answer
```

로직은 자바랑 똑같다.
array를 통해서 commands[i][0]-1:command[i][1] 을 통해서 배열을 복사한 것을 arr 배열에 넣어주었다.
그걸 이제 sort()를 사용하여 정렬시켜주었을 뿐이다. 


 