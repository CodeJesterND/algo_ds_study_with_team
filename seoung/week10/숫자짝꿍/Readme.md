## 숫자 짝꿍
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/131128)

## 문제 풀이
```
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        char []xArr = new char[X.length()];
        char []yArr = new char[Y.length()];
        
        int []yCheck = new int[10];
        
        for(int i=0;i<X.length();i++){
            xArr[i] = X.charAt(i);
        }
        
        for(int i=0; i<Y.length();i++){
            yArr[i]= Y.charAt(i);
        }
       
       
        // 체크한 값 넣어주기
        for(char ch : yArr){
            int number = ch-'0';
            yCheck[number]++;
        }
        
        List<Character> list = new ArrayList<>();
        for(char ch : xArr){
            int number = ch-'0';
            if(yCheck[number]>0) {
                char target = (char)(number+'0');
                list.add(target);
                yCheck[number]--;
            }
        }
        
       
        Collections.sort(list,Collections.reverseOrder());
        if(list.size()==0) return "-1";
        
        
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(char ch : list){
            if(flag&&ch=='0') return "0";
            flag=false;
            sb.append(ch);
        }
       
        answer = sb.toString();
        return answer;
    }
}
```

1. xArr, yArr 배열을 선언 해주었다. 해당 배열은 String 문자열을 문자형 데이터 타입으로 변환 해줄 것이다. 
2. yCheck 배열에는 10개 숫자 값이 들어와야 한다.
3. 무선 charAt을 통하여 문자열을 문자형으로 데이터를 넣어주었다. 
4. yCheck 배열에 yArr에 있는 숫자 값을 체크한 다음 값 넣어주자. 
5. 리스트를 선언하여 데이터를 넣어줄 것을 만들어주었다. 
6. xArr에 있는 숫자 값이 yCheck[number]이 0보다 큰 경우 target 값을 list에 넣어준다. 
7. 순서대로 들어왔기에 반대 순서로 Collections.sort(list, Collections.reverseOrder()); 를 해주면 반대로 리스트가 들어감. 