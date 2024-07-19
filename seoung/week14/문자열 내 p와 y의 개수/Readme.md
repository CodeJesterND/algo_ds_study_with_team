## 내 문제 풀이

1. 문자열 모두 소문자, 대문자로 만들어 판별한다.
2. y, p 이면 하나씩 증가 시켜준다. 
2. return에서 charY, charP가 같다면 true, false 로 만들어줌

```
class Solution {
    boolean solution(String s) {
        s = s.toLowerCase(); 
        int length = s.length();
        int charY = 0;
        int charP = 0;
         
        for(int i=0; i<length; i++){
            char ch = s.charAt(i);
            if(ch=='y') charY++;
            else if(ch=='p') charP++;
        }
      
        return charY==charP? true : false;
    }
}
```

# 책 문제 풀이

```
class Solution {
    boolean solution(String s) {
        int ps = 0;
        int ys = 0;
        
        for(char c : s.toCharArray()) {
            switch(c) {
                    case 'p', 'P' -> ps++;
                    case 'y', 'Y' -> ys++;
            }
        }
        return ps==ys;
    }
}
```