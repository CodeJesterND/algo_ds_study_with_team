# [link](https://school.programmers.co.kr/learn/courses/30/lessons/250121)

## 문제 풀이  - 데이터 분석

```
import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        
        List<int []> list = new ArrayList<>();
        for(int []d : data){
            if(d[map.get(ext)] < val_ext){
                list.add(d);
            }
        }
        
        list.sort(Comparator.comparingInt(arr-> arr[map.get(sort_by)]));
        
        answer = list.toArray(new int[0][]);
        
        return answer;
    }
}
```

1. map에다가 각각의 array의 위치를 넣어준다. >> 추후 sorting을 위하여 사용할 것이다. 
2. for문을 사용해서 제조일에 해당하는 부분에 맞는 부분을 제품을 list 안에다가 넣어준다.
3. list.sort를 사용하여 map.get()을 통해서 sort할 부분을 가져온다.
4. 해당 무문 arr의 값으로 list를 sort해준다. 
5. 그 후에 list.toArray를 통해서 new int[0][]부분으로 이차원 배열로 바꿔주어 answer로 리턴해주었다. 