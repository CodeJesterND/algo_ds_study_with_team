# [link](https://school.programmers.co.kr/learn/courses/30/lessons/12926)


## 문풀

1. %26으로 알파벳 25개에서 한개가 더 늘어나면 A로 가는 형식으로 구해주었다.


## 책 문풀

```
class Solution {
    public String solution(String s, int n) {
      StringBuilder answer = new StringBuilder();
     
      
       
      boolean preAplah;
      for(char password : s.toCharArray()) {
          int passNum = password;
          
          
          
          if(password==' ') answer.append(' ');
          else if(passNum >= 65 && passNum <= 96) answer.append((char)((passNum - 'A' + n ) % 26 + 'A'));          
          else if(passNum >= 97 && passNum <= 122) answer.append((char)((passNum - 'a' + n) % 26 + 'a'));
          
          
      }
        
        
      return answer.toString();
    }
}
```

# 책문풀

```
class Solution {
    
    private char push(char c, int n) {
        if(!Character.isAlphabetic(c)) return c;
        
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % ('Z' - 'A' + 1);
        return (char) (offset + position);
    }
    
    public String solution(String s, int n) {
      StringBuilder answer = new StringBuilder();
     
      for(char c : s.toCharArray()) {
          answer.append(push(c, n));
      }
        
      return answer.toString();
    }
}
```