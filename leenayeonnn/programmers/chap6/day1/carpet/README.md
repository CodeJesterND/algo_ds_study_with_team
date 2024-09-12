[프로그래머스 - 카펫](https://school.programmers.co.kr/learn/courses/30/lessons/42842)

---

### 내 풀이
```java
import java.util.Arrays;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        // 카펫의 넓이 이용해서 제곱은 추출
        // 가로 >= 세로 여야 하기 때문에 소수점 올려줌
        int w = (int) Math.ceil(Math.sqrt(brown + yellow));
        int h = 0;

        while (w < brown / 2) {

            h = brown / 2 - w + 2;
            if ((w - 2) * (h - 2) == yellow) {
                break;
            }

            w++;
        }
        
        return new int[]{w, h};
    }
}
```

<br/>

---

### 교재 풀이

```java
public class Solution {
    public int[] solution(int brown, int yellow) {
        
        for (int width = 3; width <= 5000; width++) {
            for (int height = 3; height <= width; height++) {
                int boundary = (width + height - 2) * 2;
                int center = width * height - boundary;

                if (brown == boundary && yellow == center) {
                    return new int[] {width, height};
                }
            }
        }

        return null;
    }
}
```

