## [link](https://school.programmers.co.kr/learn/courses/30/lessons/70129)

## 이진 변환 반복하기

## 문제 풀이
1. 0을 제거 
2. 0을 제거한 횟수 출력
3. 전체 count 횟수 증가 
```
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2]; 
        int count = 0;
        while(!s.equals("1")){
            int originLength = s.length();
            s = s.replaceAll("0", "");
            
            count++;
            answer[1]  += originLength - s.length();
            
            s = Integer.toBinaryString(s.length());
            
            answer[0] = count;
            
        }
        
        return answer;
    }
}
```

## 책 문제 풀이

```
class Solution {
    
    private int countZeros(String s) {
        int zeros = 0;
        for(char c : s.toCharArray()) {
            if(c == '0') zeros++;
        }
        return zeros;
    }
    
    public int[] solution(String s) {
        int[] answer = new int[2]; 
        int loop = 0;
        int removed = 0;
        while(!s.equals("1")){
            int zeros = countZeros(s);
            
            loop += 1;
            removed += zeros;
          
            int ones = s.length() - zeros;
            s = Integer.toString(ones, 2);
            
        }
    
        
        return new int[] {loop, removed};
    }
}
```
