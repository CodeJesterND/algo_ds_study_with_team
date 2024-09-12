[프로그래머스 - 메뉴 리뉴얼](https://school.programmers.co.kr/learn/courses/30/lessons/72411)

---

### 내 풀이
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public String[] solution(String[] orders, int[] course) {

        //세트를 나열할때 오름차순이여야 하기 때문에
        //orders는 정렬에 대한 내용 없기에 미리 정렬
        orders = Arrays.stream(orders)
                .map(order -> {
                    char[] charArr = order.toCharArray();
                    Arrays.sort(charArr);
                    return new String(charArr);
                })
                .toArray(String[]::new);

        Map<String, Integer> map = new HashMap<>();
        Set<String> sets = new HashSet<>();

        // 세트 개수에 따라서
        for (int c : course) {
            // order에서 세트 생성
            for (String order : orders) {
                combine(order, c, 0, "", map);
            }
            // 세트 중에 best 만 최종 결과에 넣기
            sets.addAll(findBestSets(map));
            map.clear();
        }

        String[] answer = sets.toArray(new String[0]);
        Arrays.sort(answer);

        return answer;
    }

    // 세트 생성 및 주문 횟수
    private static void combine(String order, int c, int idx, String combi, Map<String, Integer> map) {
        if (c == 0) {
            map.put(combi, map.getOrDefault(combi, 0) + 1);
            return;
        }

        for (int i = idx; i < order.length(); i++) {
            combine(order, c - 1, i + 1, combi + order.charAt(i), map);
        }
    }

    private static List<String> findBestSets(Map<String, Integer> map) {
        List<String> sets = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (String key : map.keySet()) {
            int count = map.get(key);
            if (count > max) {
                max = count;
                sets.clear();
                sets.add(key);
            } else if (count == max) {
                sets.add(key);
            }
        }

        if (max == 1) {
            sets.clear();
        }

        return sets;
    }
}
```

<br/>

---

### 교재 풀이

```java
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static class Course {
        public final String course;
        public final int occurrences;

        public Course(String course, int occurrences) {
            this.course = course;
            this.occurrences = occurrences;
        }
    }

    private void getCourses(char nextMenu, Set<String> selectedMenus,
                            List<Set<String>> orderList,
                            Map<Integer, List<Course>> courses) {

        // orders에서 현재 선택된 메뉴 셋이 있는 order의 개수 확인                                
        int occurrences = (int) orderList.stream()
                .filter(order -> order.containsAll(selectedMenus))
                .count();

        // 2 미만이면 추가 X
        if (occurrences < 2) return;

        // 선택된 메뉴 개수가 원하는 세트구성 개수일때
        int size = selectedMenus.size();
        if (courses.containsKey(size)) {
            List<Course> courseList = courses.get(size);
            Course course = new Course(selectedMenus.stream()
                    .sorted()
                    .collect(Collectors.joining("")),
                    occurrences);

            // 해당 세트 선택 횟수에 따라서 course 리스트 업데이트
            Course original = courseList.get(0);
            if (original.occurrences < occurrences) {
                courseList.clear();
                courseList.add(course);
            } else if (original.occurrences == occurrences) {
                courseList.add(course);
            }
        }

        if (size >= 10) return;

        // 세트 만들어서 재귀
        for (char menuChar = nextMenu; menuChar <= 'Z'; menuChar++) {
            String menu = String.valueOf(menuChar);
            selectedMenus.add(menu);
            getCourses((char) (menuChar + 1), selectedMenus, orderList,
                    courses);
            selectedMenus.remove(menu);
        }
    }

    public String[] solution(String[] orders, int[] course) {
        List<Set<String>> orderList = Arrays.stream(orders)
                .map(String::chars)
                .map(charStream -> charStream
                        .mapToObj(menu -> String.valueOf((char) menu))
                        .collect(Collectors.toSet()))
                .collect(Collectors.toList());

        Map<Integer, List<Course>> courses = new HashMap<>();
        for (int length : course) {
            List<Course> list = new ArrayList<>();
            list.add(new Course("", 0));
            courses.put(length, list);
        }
        getCourses('A', new HashSet<>(), orderList, courses);

        return courses.values().stream()
                .filter(list -> list.get(0).occurrences > 0)
                .flatMap(List::stream)
                .map(c -> c.course)
                .sorted()
                .toArray(String[]::new);
    }
}
```

