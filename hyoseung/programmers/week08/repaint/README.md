## 덧칠하기

```java
class Solution {
public int solution(int n, int m, int[] section) {
int start = section[0];
int end = section[0] + (m - 1);
int answer = 1;

        for (int i : section) {
            if (i >= start && i <= end) {
                continue;
            }
            else {
                start = i;
                end = i + (m - 1);
                answer++;
            }
        }
        
        return answer;
    }
}
```

* 먼저, 첫 번째 섹션의 시작과 끝을 계산한다.
* 주어진 섹션 배열을 순회하면서 각 섹션이 현재 덧칠하려는 영역에 속하는지를 확인한다.
* 만약 섹션이 현재 영역에 속한다면 넘어가고, 아니라면 새로운 영역으로 간주하고 새로운 페인트 통이 필요하다는 것을 의미한다.
* 마지막으로 필요한 페인트 통의 개수를 반환한다.