# [link](https://school.programmers.co.kr/learn/courses/30/lessons/12918)

## 문자열 다루기 기본

1. 문자열 4 또는 6인지 판별하기
2. NumberFormatException 에러가 나면 false를 반환하도록 함.
```
class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int length = s.length();
        if(length != 4 && length != 6 ) return false;
        
        try{
            Integer.parseInt(s);
        }catch(NumberFormatException e){
            return false;
        }
        return answer;
    }
}
```


## 책 문제 풀이

1. Character.isDigit(c) 로 숫자가 아니라면 false로 반환
````
class Solution {
    public boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6) return false;
        
        for(char c: s.toCharArray()) {
            if(!Character.isDigit(c)) return false;
        }
        return true;
    }
}
````