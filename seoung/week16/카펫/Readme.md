## [Link](https://school.programmers.co.kr/learn/courses/30/lessons/42840)
## 모으고사


## 내가 푼 풀이
1. 우선 가장 가로길이 , 세로 길이는 3이상이어야 한다. 그 이유는 세로가 3개이상이어야 가운데가 있을 수 있으며, 가로의 길이가 세로의 길이보다 길어야 하므로 가로 세로는 3이상이어야 한다. 
2. 가운데를 구하기 위해서는 위에 아래 높이를 기준으로 -2 를 해주면 가운데를 구할 수 있음. 나는 이것을 가로도 적용했다. 
3. total 을 i로 나누어 떨이지는 수 중에서 1번을 지키는 것을 가장 먼저 출력시 켜주었다. 
4. col이 커야 하기에  i,j 중에 큰 값을 가로에 작은 값을 세로에 넣어주어 정답을 구해주었다. 
```
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        
        for(int i=3;i<total; i++) {
            int j = total / i;
            
            if(total % i==0 && j >= 3) {
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                int center = (col - 2) * (row - 2);
                
                if(center == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;
    }
}
```

## 책 풀이
1. 컨셉은 비슷한데 조금 더 width , heigth에 대한 부분을 잘 풀었고, (width + height - 2) * 2 이 부분을 생각을 아예 못했음. 그림으로만 이해했지 공식으로 그리지는 못한거 같음. 

```
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
