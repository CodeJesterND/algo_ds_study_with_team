## 카펫

<br/>

### 책 참조 전 상태의 코드
```java
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow; 

        for (int i = 3; i < sum / 2; i++) {
            int row = i;
            int col = sum / row;
            
            // (행-2) * (열-2) 가 노란색 격자의 개수와 일치하는 경우
            if ((row - 2) * (col - 2) == yellow) {
                answer[0] = col;
                answer[1] = row;
                break;
            } 
        }
    
        return answer;
    }
}
```

### 책 참조 후 상태의 코드
```java
class Solution {
    public int[] solution(int brown, int yellow) {
       for(int width=3; width <= 5000; width++) {
           for(int height=3; height <= width; height++) {
               int boundary = (width + height - 2) * 2;
               int center = width * height - boundary;
               if(brown == boundary && yellow == center) {
                   return new int[] {width, height};
               }
           }
       } 
       return null;
    }
}
```