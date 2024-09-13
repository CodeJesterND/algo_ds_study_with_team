## 메뉴리뉴얼
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/72411)


## 내가 푼 문제 풀이
```
import java.util.*;

class Solution {
    public static HashMap<String, Integer> newOrder;
    public static int[] ordCnt;
    
    
    public String[] solution(String[] orders, int[] course) {
        newOrder = new HashMap<>();
        ordCnt = new int[11];
        
        for(String item : orders) {
            char[] temp = item.toCharArray();
            Arrays.sort(temp); // 알파벳 순으로 정렬되어야 하기 때문에
            String newItem = String.valueOf(temp);
            orderCombine(new boolean[newItem.length()], 0, newItem, course);
        }
        
        
        ArrayList<String> list = new ArrayList<>();
        
        for(String item : newOrder.keySet()) {
            int len = item.length();
            for(int i=0; i< course.length; i++) {
                if(len == course[i]) {
                    if(ordCnt[len] == newOrder.get(item)) {
                        list.add(item);
                    }
                }
            }
        }
        
        Collections.sort(list);
        String[] answer = new String[list.size()];
        int idx = 0;
        for(String item : list) {
            answer[idx++] = item;
        }
        
        return answer;
    }
    
    
    public static void orderCombine(boolean[] visited, int depth, String order, int[] course) {
        if(depth == order.length()) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < order.length(); i++) {
                if(visited[i]) {
                    sb.append(order.charAt(i));
                }
            }
            
            if(sb.length() < 2) {
                return ;
            }
            
            for(int n : course) {
                if(sb.length() == n) {
                    if(!newOrder.containsKey(sb.toString()))  {
                        newOrder.put(sb.toString(), 1);
                    } else {
                        newOrder.put(sb.toString(), newOrder.get(sb.toString()) + 1);
                        ordCnt[sb.length()] = Math.max(ordCnt[sb.length()], newOrder.get(sb.toString()));
                    }
                }
            }
        } else {
            visited[depth] = true;
            orderCombine(visited, depth + 1, order, course);
            visited[depth] = false;
            orderCombine(visited, depth + 1, order, course);
        }
    }
}
```

- newOrder: 각 메뉴 조합(키)과 그 조합이 등장한 횟수(값)를 저장
- ordCnt : 각 조합 길이에 대해 가장 많이 등장한 횟수를 저장. 배열의 인덱스는 조합의 길이를 나타낸다. 
- solution 메서드 : 입력으로 받은 주문 목록(orders), 코스 길이 목록(course)을 기반으로 모든 가능한 메뉴 조합을 생성하고, 가장 많이 주문된 메뉴 조합을 찾아 반환
- orderCombine 메서드 : 재귀적으로 메뉴 조합을 생성하는 역할 

상세 동작 과정
각 주문(orders)에서 알파벳 순으로 정렬된 메뉴 조합을 만든다. orderCombine메서드를 호출하여 가능한 메뉴 조합을 모두 찾는다. 
```
for(String item : orders) {
    char[] temp = item.toCharArray();
    Arrays.sort(temp); // 메뉴 조합을 알파벳 순으로 정렬
    String newItem = String.valueOf(temp);
    orderCombine(new boolean[newItem.length()], 0, newItem, course); 
}
```