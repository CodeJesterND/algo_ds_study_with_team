## 둘만의 암호

```java
public class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            int count = 0;
            
            while (count < index) {
                c++;
                
                if (c > 'z') {
                    c -= 26;
                }
                
                if (!skip.contains(String.valueOf(c))) {
                    count++;
                }
            }
            
            answer.append(c);
        }
        
        return answer.toString();
    }
}
```

* s 의 각 문자를 순환하며, `index` 횟수만큼 순환하여 문자를 증가시키며, 만약 문자가 `z`를 초과하면 `a`로 되돌린다.
* `skip` 문자열에 포함되지 않은 문자를 발견할 때마다 `count` 를 증가시킨다.
* 그리고 `index` 횟수만큼 이동한 최종 문자를 `answer` 에 추가한다.
* 모든 문자를 처리한 후 최종 결과 문자열을 반환한다.