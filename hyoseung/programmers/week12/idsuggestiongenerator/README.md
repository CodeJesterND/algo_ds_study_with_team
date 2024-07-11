## 신규 아이디 추천

```java
class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase(); // 1단계

        answer = answer.replaceAll("[^-_.a-z0-9]", ""); // 2단계
        answer = answer.replaceAll("[.]{2,}", "."); // 3단계
        answer = answer.replaceAll("^[.]|[.]$", "");    // 4단계

        if (answer.isEmpty()) { // 5단계
            answer += "a";
        }

        if (answer.length() >= 16) { // 6단계
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }

        return answer;
    }
}
```

* `toLowerCase()` 메서드를 사용하여 new_id를 모두 소문자로 변환한다.
* `replaceAll("[^-_.a-z0-9]", "")`를 사용하여 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자를 제거한다.
* `replaceAll("[.]{2,}", ".")`를 사용하여 연속된 마침표를 하나의 마침표로 치환한다.
* `replaceAll("^[.]|[.]$", "")`를 사용하여 처음이나 끝에 위치한 마침표를 제거한다.
* `isEmpty()`로 빈 문자열인지 확인하고, 빈 문자열이면 `a`를 추가한다.
* 15개 문자를 초과하는 경우, 15번째 문자까지 잘라낸다.
* 만약 잘라낸 문자열의 마지막 문자가 마침표`.`라면 이를 제거한다.
* 길이가 3이 될 때까지 마지막 문자를 반복하여 추가한다.