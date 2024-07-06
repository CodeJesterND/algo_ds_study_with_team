# [link](https://school.programmers.co.kr/learn/courses/30/lessons/67256)

## 키패드 누르기 - 문제풀이 
```
// 맨하튼의 공식을 사용하여 푼다.
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left = 10;
        int right = 12;
        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7) {
                answer.append("L");
                left = number;
            }
            else if(number == 3 || number == 6 || number == 9) {
                answer.append("R");
                right = number;
            }
            else {
              if(number == 0) number = 11;
              int leftDis = Math.abs(number - left) / 3 + Math.abs(number - left) % 3;
              int rightDis = Math.abs(number - right) / 3 + Math.abs(number - right) % 3;
                
              if(leftDis < rightDis) {
                  answer.append("L");
                  left = number;
              } else if(rightDis < leftDis) {
                  answer.append("R");
                  right = number;
              }else {
                  if(hand.equals("left")){
                      answer.append("L");
                      left = number;
                  }else {
                      answer.append("R");
                      right = number;
                  }
              }
            }
        }
        return answer.toString();
    }
}
```

## 멘하튼의 공식은 |x1-x2| + |y1 - y2| y끼리 차이의 절대 값이다.
1. 초기 왼손 , 오른손 위치는 숫자로 표현할 때, 10, 12이다. 
2. 1 4 7 위치에 있는 것들은 왼쪽을 이용한다. 그렇기에 answer append를 추가하고 left에 number를 대입한다.
3. 3 6 9 위치는 무조건 right 오른손이 움직인다. 동일한 로직
4. 그 밖이라면 가운데 위치 가운데 위치면 다가까운데 움직인다. 좌표를 따졌을 때, x축이 Math.abs(number - left)이고 Math.abs(number-left) % 3 y축이다. 
5. 이렇게 했을 때, 더 가까운 것을 구해준다. 그것을 통해 분기를 정해준다. 
6. 위치가 똑같다면 어떤 손잡이인지에 따라 움직임.