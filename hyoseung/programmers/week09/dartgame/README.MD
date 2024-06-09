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

* 입력된 다트 결과 문자열을 순회하며 각각의 문자에 대한 점수를 계산한다.
* 숫자인 경우 해당 숫자를 점수 배열에 저장합니다. 만약 10인 경우에는 다음 문자도 확인하여 처리한다.
* 점수를 계산하는데, `S`, `D`, `T`는 각각 1제곱, 2제곱, 3제곱을 수행한다.
* `*`은 현재 점수와 그 전 점수를 2배로 만든다.
* `#`은 현재 점수를 음수로 만든다.
* 모든 점수를 합산하여 반환한다.