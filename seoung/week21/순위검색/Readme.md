## [link](https://school.programmers.co.kr/learn/courses/30/lessons/72412)

## 순위 검색


1. info 정보를 '-'를 추가하여 모든 조합을 가져와주어야함.

java backend junior pizza 150
위에를 조합하였을 때, 아래와 같이 나온다. 
```
-backendjunior-
java--pizza
javabackend--
---pizza
-backend--
-backend-pizza
java---
-backendjuniorpizza
javabackendjuniorpizza
--junior-
javabackend-pizza
----
java-juniorpizza
java-junior-
javabackendjunior-
--juniorpizza
```
이것을 조합수를 통해서 구해줄 것이다. 완전 탐색으로 구해준다. 

## 전체코드
```
import java.util.*;

class Solution {
    
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    
    
    public int[] solution(String[] infos, String[] query) {
        int[] answer = {};
        
        for(String info : infos) {
            combination("", info.split(" "), 0);
        }
        
        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        answer = new int[query.length];
        for(int i=0;i<query.length; i++) {
           query[i] = query[i].replaceAll(" and ", "");
           String []q = query[i].split(" ");
           answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0; 
        }
        
        return answer;
    }
    
    
    public static int binarySearch(String key, int score){
        
        ArrayList<Integer> list = map.get(key);
        int start = 0;
        int end = list.size() - 1;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(list.get(mid) < score) start = mid + 1;
            else end = mid -1;
        }
        
        return list.size() - start;
    }
    
    public static void combination(String str, String[] info, int depth){       
        if(depth==4) {
            
            if(map.containsKey(str)) {
                map.get(str).add(Integer.parseInt(info[4]));
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(info[4]));
                map.put(str, list);
            }
            return ;
        }
        
        combination(str+"-", info, depth+1);
        combination(str+info[depth], info, depth+1);
    }
}
```

조합
```
 public static void combination(String str, String[] info, int depth){       
        if(depth==4) {
            
            if(map.containsKey(str)) {
                map.get(str).add(Integer.parseInt(info[4]));
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(info[4]));
                map.put(str, list);
            }
            return ;
        }
        
        combination(str+"-", info, depth+1);
        combination(str+info[depth], info, depth+1);
    }
```

combination(String str, String[] info, int depth)
- info 배열을 바탕으로 조합을 만들고, 그 조합을 map에 저장하는 메서드
- str은 현재까지 생성된 조합을 나타내는 문자열
- depth는 탈출을 시키기위한 깊이를 만들어줌

if(depth==4)
- depth가 4가 되면 재귀가 종료됨
- info 배열의 앞의 str 조합이 완성되고, 해당 str을 map저장해주는 분기문이다.

if(map.containsKey(str))
- 해당 조합이 map에 존재하는지 확인합니다. 
- 만약 존재하면, 해당 키(str)에 점수(info[4])를 추가합니다. 
- 존재하지 않으면, 새로운 리스트를 생성하여 점수를 추가한 후 map에 새로운 키와 함께 저장된다. 

combination(str + "-", info, depth + 1)
- 현재 깊이(depth)에서 str에 "-"을 추가하고, 재귀 호출을 통해 다음을 넘어간다.

combination(str + info[depth], info, depth + 1)
- 이번에는 info[depth]값을 str에 추가하고, 재귀 호출을 통해 다음 깊이로 넘어간다.


```
for(String key : map.keySet()) {
            Collections.sort(map.get(key));
}
```

2.오름차순정렬을 해준다. <- 이진트리를 구하기 위해서다.

```
for(int i=0;i<query.length; i++) {
           query[i] = query[i].replaceAll(" and ", "");
           String []q = query[i].split(" ");
           answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0; 
}
```

3.replace를 통해서 and를 하나의 문자열로 합쳐주고 해당값을 키로 저장 한칸 띄워져있는 숫자는 score로 사용

```
 public static int binarySearch(String key, int score){
        
        ArrayList<Integer> list = map.get(key);
        int start = 0;
        int end = list.size() - 1;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(list.get(mid) < score) start = mid + 1;
            else end = mid -1;
        }
        
        return list.size() - start;
    }
```
ArrayList<Integer> list = map.get(key);
- key에 해당하는 값으로 map에서 ArrayList<Integer>로 가져온다. 
- list는 정렬된 상태라고 가정된다. 이진 탐색은 정렬된 데이터에서만 작동 그래서 위에서 정렬해준 것.

int start = 0; int end = list.size() - 1;
- 이진 탐색 시작을 위해서 start, end 시작점을 만들어줌
- start는 배열의 첫 번째 인덱스를 가리킨다. end는 배열의 마지막 인덱스를 가리킨다.

while(start<=end)
- 이진 탐색을 수행할 루프이다. start가 end보다 크지 않을 동안 계속 반복함.
- mid를 찾아 조건을 검색한다.

int mid = (start + end) / 2;
- mid를 통해서 조건을 통해 탐색을 줄인다. 

return list.size() - start;
이진 탐색이 끝나면 start는 score보다 큰 값을 가르킨다.
따라서 list.size() - start를 반환함으로써, score보다 크거나 같은 값이 몇 개인지를 계산합니다.



## 책 문제 풀이 

```
import java.util.*;
import java.util.function.Consumer;

class Solution {
    
    private void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action) {
        if(index == tokens.length -1) {
            action.accept(prefix);
            return ;
        }
        
        forEachKey(index + 1, prefix + tokens[index] , tokens, action);
        forEachKey(index + 1, prefix + "-", tokens, action);
    }
    
    private Map<String, List<Integer>> buildScoresMap(String[] info) {
        Map<String, List<Integer>> scoresMap = new HashMap<>();
        
        for(String s : info) {
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);
            
            forEachKey(0, "", tokens, key-> {
               scoresMap.putIfAbsent(key, new ArrayList<>());
               scoresMap.get(key).add(score);
            });
        }
        
        for(List<Integer> list : scoresMap.values()) {
            Collections.sort(list);
        }
        
        return scoresMap;
    }
    
    
    private int binarySearch(int score, List<Integer> scores) {
        int start = 0;
        int end = scores.size() -1;
        
        while(end > start) {
            int mid = (start + end) / 2;
            
            if(scores.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        if(scores.get(start) < score) {
            return scores.size();
        }
        
        return start;
    }
    
    
    private int count(String query, Map<String, List<Integer>> scoresMap) {
        String[] tokens = query.split(" (and )?");
        
        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));
        
        if(!scoresMap.containsKey(key)) return 0;
        List<Integer> scores = scoresMap.get(key);
        
        int score = Integer.parseInt(tokens[tokens.length-1]);
        
        return scores.size() -binarySearch(score, scoresMap.get(key));
    }
    
    public int[] solution(String[] infos, String[] query) {
           
        Map<String, List<Integer>> scoresMap = buildScoresMap(infos);
        
        int[] answer = new int[query.length];
        
        for(int i=0; i < answer.length; i++) {
            answer[i] = count(query[i], scoresMap);
        }
        
        return answer;
        
    }
    
    
}
```