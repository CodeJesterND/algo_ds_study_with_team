## 평행

<br/>

### 책 참조 전 상태의 코드
```java
class Solution {
    public int solution(int[][] dots) {
        if (isParallel(dots[0], dots[1], dots[2], dots[3])) return 1;
        if (isParallel(dots[0], dots[2], dots[1], dots[3])) return 1;
        if (isParallel(dots[0], dots[3], dots[1], dots[2])) return 1;
        
        return 0;
    }
    
    private boolean isParallel(int[] dot1, int[] dot2, int[] dot3, int[] dot4) {
        return (dot2[1] - dot1[1]) * (dot4[0] - dot3[0]) == (dot4[1] - dot3[1]) * (dot2[0] - dot1[0]);
    }
}
```

<br/>

### 책 참조 후 상태의 코드
```java
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public double getSlope(int x1, int y1, int x2, int y2) {
        return (double) (y2 - y1) / (x2 - x1);
    }
    
    public int solution(int[][] dots) {
        Set<Double> slopes = new HashSet<>();
        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                double slope = getSlope(dots[i][0], dots[i][1], 
                                        dots[j][0], dots[j][1]);
                if (slope.contains(slope)) {
                    return 1;
                }
                slopes.add(slope);
            }
        }
        return 0;
    }
}
```