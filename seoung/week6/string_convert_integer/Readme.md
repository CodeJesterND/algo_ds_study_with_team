# 문자열을 정수로 바꾸기 

## [link](https://school.programmers.co.kr/learn/courses/30/lessons/12925)
```
class Solution {
    public int solution(String s) {
        int answer=0;
        char []ch = s.toCharArray(); // 배열을 []ch에 담아준다.
        
        boolean flag = false; // 상태 확인
        for(int i=0;i<ch.length; i++){
            answer*=10; // 10씩 곱해주는 부분
            if(ch[i]=='+') continue; // '+' 부분이면 생략하고 Continue
                
            if(ch[i]=='-') { // '-' 인 경우, true (Exception) 처리
                flag = true;
                continue;
            } 
            
            answer += Character.getNumericValue(ch[i]); // getNumbericValue Character를 answer에 더해주는 부분
        } // 
        if(flag) answer*=-1;
        
        return answer;
    }

}
```