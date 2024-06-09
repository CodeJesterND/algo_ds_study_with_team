## [1차] 다트 게임

```java
import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int index = -1;
        int length = dartResult.length();

        for(int i = 0; i < length; i++) {
            char ch = dartResult.charAt(i);

            if(Character.isDigit(ch)) {
                index++;
                if (dartResult.charAt(i + 1) == '0') {
                    scores[index] = 10;
                    i++;
                } else {
                    scores[index] = ch - '0';
                }
            } else {
                switch (ch) {
                    case 'S':
                        scores[index] = (int) Math.pow(scores[index], 1);
                        break;
                    case 'D':
                        scores[index] = (int) Math.pow(scores[index], 2);
                        break;
                    case 'T':
                        scores[index] = (int) Math.pow(scores[index], 3);
                        break;
                    case '*':
                        scores[index] *= 2;
                        if (index > 0) {
                            scores[index - 1] *= 2;
                        }
                        break;
                    case '#':
                        scores[index] *= -1;
                        break;
                }
            }
        }
        return Arrays.stream(scores).sum();
    }
}
```