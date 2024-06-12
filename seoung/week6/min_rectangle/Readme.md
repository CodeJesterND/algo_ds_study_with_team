## 최소 직사각형 

## [link](https://school.programmers.co.kr/learn/courses/30/lessons/86491)

# 문제 풀이
```
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
  
        int mw = Integer.MIN_VALUE;
        int mh = Integer.MIN_VALUE;
        for(int i=0; i<sizes.length;i++){
           if(sizes[i][0]>sizes[i][1]){
               int temp = sizes[i][0];
               sizes[i][0] = sizes[i][1];
               sizes[i][1] = temp;
        
           } 
           mw = Math.max(mw, sizes[i][0]);
           mh = Math.max(mh, sizes[i][1]); 
            
        }
        
        answer = mw *mh;
        
        
        return answer;
    }
}
```