## 순위 검색

<br/>

### 책 참조 전 상태의 코드
```java
import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        // 1. info를 기반으로 hashMap 만들기
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
        
        for (String i : info) {
            String[] data = i.split(" ");
            String[] languages = { data[0], "-" };
            String[] jobs = { data[1], "-" };
            String[] exps = { data[2], "-" };
            String[] foods = { data[3], "-" };
            Integer value = Integer.parseInt(data[4]);
            for (String lang : languages)
                for (String job : jobs)
                    for (String exp : exps)
                        for (String food : foods) {
                            String[] keyData = { lang, job, exp, food };
                            String key = String.join(" ", keyData);
                            ArrayList<Integer> arr = hashMap.getOrDefault(key, new ArrayList<Integer>());

                            arr.add(value);
                            hashMap.put(key, arr);
                        }
        }

        // 2. 각 hashMap의 value를 오름차순 정렬하기
        for (ArrayList<Integer> scoreList : hashMap.values())
            scoreList.sort(null);

        // 3. query 조건에 맞는 지원자를 가져오기
        int[] answer = new int[query.length];
        int i = 0;
        for (String q : query) {
            String[] data = q.split(" and ");
            int target = Integer.parseInt(data[3].split(" ")[1]);
            data[3] = data[3].split(" ")[0];
            String key = String.join(" ", data);

            if (hashMap.containsKey(key)) {
                ArrayList<Integer> list = hashMap.get(key);
                // 4. lower-bound/하한선 찾기
                int left = 0;
                int right = list.size();
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) >= target)
                        right = mid;
                    else
                        left = mid + 1;
                }

                answer[i] = list.size() - left;
            }
            i++;
        }
        return answer;
    }
}
```

<br/>

### 책 참조 후 상태의 코드
```java
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