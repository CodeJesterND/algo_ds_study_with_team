# 둘만의 암호
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/155652)

## 문제풀이 
1. 소문자를 반복문을 통해서 list에 넣어준다.
2. skip되어야 하는 것들을 제거해준다. 
3. 각각을 반복을 통해서 반복해준다. 
4. arrayList에서 특정 문자의 위치를 가져온다. 
5. targetIndex + index를 더한 후 % arrayList.size를 나눈다. arrayList.size()를 넘을 경우 한 바퀴돌아서 처음부터 해줘야되는 처리를 해줌
6. 이후에 StringBuilder에서 해당 값을 넣어주어 구해준다.
````
import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        ArrayList<Character> arrayList = new ArrayList<>();
       
        for(int i=0;i<26;i++){
            arrayList.add((char)(i+97));
        } 
       
        for(Character c : skip.toCharArray()) {
            arrayList.remove(c);
        } 
        
        
        for(Character c : s.toCharArray()){ 
          int targetIndex  = arrayList.indexOf(c); 
          int num = (targetIndex + index) % arrayList.size(); 
          answer.append(arrayList.get(num));  
        }
        return answer.toString();
    }
}
````