# 대충 만든 자판
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/160586)

## 문제 풀이 
1. alpha라는 자판기 위치의 숫자를 넣어줄 배열을 하나 만들어준다.
2. 그 밑은 Arrays.fill로 -1로 쭉 채워준다. 
3. keyboard 배열을 반복문으로 돌면서 각각의 char형이 나온 최소 값을 넣어준다. 
4. if(alphaNum[ch-65]<0) 은 음수인 경우 최초로 판단하여 바로 넣어준다.
5. else인 경우 어느것이 더 작은 수인지 판단하고 해당 값을 넣어준ㄷ나. 
6. 만약에 하나라도 존재 하지 않는 수인 경우 음수이어야 하기 때문에 alphaNum[ch-65]<0을 통해서 -1을 더해주었다. 
7. 이런 경우가 아니라면 정상처리이기 때문에 alphaNum[ch-65]를 통해서 구해주었다. 

```
// 키 하나에 여러 문자가 할당된 경우, 동일한 키를 연속해서 빠르게 누르면 할당된 순서대로 문자
// 예를 들어, 1번 키에 "A", "B", "C" 순서대로 문자가 할당되어 있다면 1번 키를 한 번 누르면 "A", 두 번 누르면 "B", 세 번 누르면 "C"가 되는 식입니다.
// 같은 규칙을 적용해 아무렇게나 만든 휴대폰 자판이 있습니다. 이 휴대폰 자판은 키의 개수가 1개부터 최대 100개까지 있을 수 있으며, 특정 키를 눌렀을 때 입력되는 문자들도 무작위로 배열되어 있습니다.
// 또, 같은 문자가 자판 전체에 여러 번 할당된 경우도 있고, 키 하나에 같은 문자가 여러 번 할당된 경우도 있습니다. 심지어 아예 할당되지 않은 경우도 있습니다. 따라서 몇몇 문자열은 작성할 수 없을 수도 있습니다.
// 
import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = {};
        int[] alphaNum = new int[26];
        Arrays.fill(alphaNum, -1);
        
        for(int i=0;i<keymap.length;i++){
            for(int j=0;j<keymap[i].length(); j++){
                char ch = keymap[i].charAt(j);
                if(alphaNum[ch-65]<0) alphaNum[ch-65] = j+1;
                else alphaNum[ch-65] = (alphaNum[ch-65] < j+1) ? alphaNum[ch-65] : j+1;
            }
        }
        
        answer = new int[targets.length];
        for(int i=0; i<targets.length; i++){
            for(int j=0; j<targets[i].length(); j++){
                char ch = targets[i].charAt(j);
                if(alphaNum[ch-65] < 0) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += alphaNum[ch-65];
            }
            
        }
        
        return answer;
    }
}
```