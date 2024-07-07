## 키패드 누르기

```java
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        // 왼손과 오른손의 초기 위치 설정
        int left = 10;   // '*'을 의미
        int right = 12;  // '#'을 의미
        
        // 주어진 숫자 배열을 순회하며 처리
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            
            // 1, 4, 7인 경우 왼손 사용
            if (n == 1 || n == 4 || n == 7) {
                left = n;
                answer.append("L");
            } 
            // 3, 6, 9인 경우 오른손 사용
            else if (n == 3 || n == 6 || n == 9) {
                right = n;
                answer.append("R");
            } 
            // 2, 5, 8, 0인 경우 가까운 손 사용 결정
            else {
                // 숫자 0은 키패드 상 11로 처리
                if (n == 0) {
                    n = 11;
                }
                
                // 왼손과의 거리 계산
                int leftDist = Math.abs(n - left) / 3 + Math.abs(n - left) % 3;
                // 오른손과의 거리 계산
                int rightDist = Math.abs(n - right) / 3 + Math.abs(n - right) % 3;
                
                // 왼손과 오른손 거리 비교하여 가까운 손을 선택
                if (leftDist < rightDist) {
                    answer.append("L");
                    left = n;
                } else if (leftDist > rightDist) {
                    answer.append("R");
                    right = n;
                } 
                // 왼손과 오른손 거리가 같을 때, 사용자 설정(hand)에 따라 손 선택
                else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        left = n;
                    } else {
                        answer.append("R");
                        right = n;
                    }
                }
            }
        }
        
        return answer.toString();
    }
}
```

* `left`와 `right` 변수는 각각 왼손과 오른손의 초기 위치를 나타낸다.
* 여기서 10은 '*' 키패드의 위치를, 12는 '#' 키패드의 위치를 의미한다.
* `numbers` 배열을 순회하며 각 숫자를 처리한다.
* 숫자가 1, 4, 7인 경우 왼손을 사용하고, 결과 문자열에 "L"을 추가한다.
* 숫자가 3, 6, 9인 경우 오른손을 사용하고, 결과 문자열에 "R"을 추가한다.
* 숫자가 2, 5, 8, 0인 경우 가까운 손을 결정한다.
* 숫자 0은 키패드에서 11로 처리한다.
* `left` 과 숫자 사이의 `leftDist` 와 `right` 과 숫자 사이의 `rightDist` 를 계산한다.
* 거리 계산식은 키패드의 행과 열로부터 유클리디안 거리를 계산하여 구현했다.
* `leftDist`와 `rightDist`를 비교하여 가까운 손을 선택한다.
* 거리가 같을 경우, `hand` 값에 따라 왼손 또는 오른손을 선택한다.
* 최종적으로 왼손과 오른손을 사용한 결과 문자열을 반환한다.