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