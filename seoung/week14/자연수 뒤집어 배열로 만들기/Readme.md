# [link](https://school.programmers.co.kr/learn/courses/30/lessons/12932)


## 문제 풀이
1. toCharArray로 char 배열로 바꾸고 해당 배열을 꺼구로 하나씩 꺼내서 -'0'해준다.

```
import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        char[] value = String.valueOf(n).toCharArray();
        int[] answer = new int[value.length];
        
        int index = 0;
        for(int i=value.length-1; i>=0; i--){
            answer[index] = value[i]-'0';
            index+=1;
        }
        
        return answer;
    }
}
```
