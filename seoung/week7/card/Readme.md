## 카드 뭉치
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/159994)

```
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int totalCount = cards1.length + cards2.length;
        int cards1_num = 0;
        int cards2_num = 0;
        
        for(String currentString : goal){
            if(cards1_num < cards1.length && currentString.equals(cards1[cards1_num])){
                cards1_num++;
            } else if(cards2_num < cards2.length && currentString.equals(cards2[cards2_num])){
                cards2_num++;
            } else {
                answer = "No";
            }
            
        }
        
        System.out.println(totalCount);
        return answer;
    }
    
}
```

1. 순서대로 들어온 값을 비교해 있으면 넣어준다. 아니라면 else No가 나온다.
2. 해당 문제는 쉬웠음