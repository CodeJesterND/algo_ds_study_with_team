# [Link](https://school.programmers.co.kr/learn/courses/30/lessons/161990)

## 바탕화면 정리 - 문제풀이

```
import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int [][]board = new int[wallpaper.length][wallpaper.length];
        int hMin = Integer.MAX_VALUE;
        int wMin = Integer.MAX_VALUE;
        int hMax = Integer.MIN_VALUE;
        int wMax = Integer.MIN_VALUE;
        int hCount =0;
        for(String paper : wallpaper){
            
            char[] chArr = paper.toCharArray();
            int wCount = 0;
            for(char ch: chArr){
                if(ch=='#'){
                    hMax = hCount > hMax ? hCount : hMax;
                    hMin = hCount < hMin ? hCount : hMin;
                    wMax = wCount > wMax ? wCount : wMax;
                    wMin = wCount < wMin ? wCount : wMin; 
                }
                wCount++;
            }
            hCount++;
        }
        
        answer = new int[]{hMin, wMin, hMax+1, wMax+1};
        return answer;
    }
}
```

1. 각각 min, max를 나타 낼 변수들을 선언 해주었다.
2. #을 만났을 때의 최소 값 최대 값을 저장하고 이를 통해서 answer배열을 만들어주면 정답이 나온다.