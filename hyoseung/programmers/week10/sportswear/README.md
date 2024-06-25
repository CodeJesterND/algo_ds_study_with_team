## 체육복

```java
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] students = new int[n]; // 학생들의 체육복 상태를 나타내는 배열 생성..!
        Arrays.fill(students, 1); // 처음에는 모두에게 체육복을 지급..!
        
        for (int l : lost) { // lost를 기준으로 학생들의 체육복 수 감소..!
            students[l - 1]--;
        }
        
        for (int r : reserve) { // reserve를 기준으로 여벌의 체육복을 가진 학생의 체육복 수 증가..!
            students[r - 1]++;
        }
        
        for (int i= 0; i < n; i++) {
            if (students[i] == 0) { // 체육복이 없는 상태를 만났을 때...!
                if (i - 1 >= 0 && students[i - 1] == 2) { // 앞 사람 체육복이 2개라면..!
                    students[i]++; // 빌렸기 때문에 현재 체육복 상태 추가
                    students[i - 1]--; // 빌려준 상태 저장
                } else if (i + 1 < n && students[i + 1] == 2) { // 뒷 사람 체육복이 2개라면..!
                    students[i]++; // 빌렸기 때문에 현재 체육복 상태 추가
                    students[i + 1]--; // 빌려준 상태 저장
                }
            }
        }
        
        for (int s : students) { 
            if(s > 0) { // 최종적으로 체육복이 있는 학생 수를 체크한다.
                answer++;
            }
        }
        
        return answer;
    }
}
```

* `students` 배열을 생성하여 각 학생의 체육복 상태를 나타내는 배열이다.
* 초기값으로 모든 학생에게 체육복이 하나씩 있는 상태로 설정한다.
* `lost` 배열을 순회하면서 체육복을 도난당한 학생들의 체육복 수 `students[l - 1]--` 를 감소시킨다. 
* `reserve` 배열을 순회하면서 여벌의 체육복을 가진 학생들의 체육복 수 `students[r - 1]++` 를 증가시킨다. 
* 모든 학생을 순회하면서 체육복이 없는 `students[i] == 0` 을 찾는다.
* 앞뒤로 체육복이 있는 `students[i - 1]` 또는 `students[i + 1]` 이 2일 경우 체육복을 빌려준다. 
* 이를 통해 가능한 많은 학생이 체육복을 입을 수 있도록 한다.
* 최종적으로 체육복이 있는 학생의 수를 세어 `answer` 변수에 저장하여 반환한다.