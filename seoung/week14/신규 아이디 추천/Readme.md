## 신규 아이디 추천 

## 내 문제 풀이
1. 죄송해요.. 그대로 가져왔어요 대역죄인이에요
```
class Solution {
    public String solution(String new_id) {
        // 1단계
        String answer = new_id.toLowerCase();
        
        answer = answer.replaceAll("[^a-z0-9-_.]","") // 2단계
                       .replaceAll("\\.{2,}",".") // 3단계
                       .replaceAll("^[.]|[.]$", ""); // 4단계
    
        if(answer.equals("")) answer += "a"; // 5단계
        if(answer.length() >= 16) answer = answer.substring(0,15); // 6단계 먼저 시작하고 실행 
        
        answer = answer.replaceAll("^[.]|[.]$", ""); // 4단계 반복 처음 끝 . 삭제
        while(answer.length() < 3) { // 7단계
           String ch = String.valueOf(answer.charAt(answer.length()-1));
           answer += ch;
        }
        
        return answer;
    }
}
```

## 책 문제 풀이

```
class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]","");
        new_id = new_id.replaceAll("\\.+", ".");
        new_id = new_id.replaceAll("^\\.+|\\.+$","");
        new_id = new_id.replaceAll("^\\.+|\\.$", "");
        
        if(new_id.isEmpty()) new_id = "a";
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0,15);
            new_id = new_id.replaceAll("\\.+$","");
        }
       
        while(new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        
        
        return new_id;
    }
}
```