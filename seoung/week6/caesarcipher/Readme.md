## 시저암호
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/12926)

# 문제 풀이 
```
class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
           
            if(ch ==' ') ch = ' ';
            else if(Character.isUpperCase(ch)){
                  ch = (char)((ch + n - 'A') % 26 +'A');
            }
            else if(Character.isLowerCase(ch)) {
                ch = (char)((ch + n - 'a') % 26 + 'a');
            }  
           
            sb.append(ch);
            
        }
        
        return sb.toString();
    }
}
```