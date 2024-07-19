[프로그래머스 - 신규 아이디 추천](https://school.programmers.co.kr/learn/courses/30/lessons/72410)

---

### 내 풀이
```java
class Solution {
    public String solution(String new_id) {

        // 1. 대문자 -> 소문자
		new_id = new_id.toLowerCase();

        // 2. 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 제외 모든 문자 제거
		new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        // 3. 마침표(.) 2번 이상 연속된 부분 => 하나의 마침표(.)
		new_id = new_id.replaceAll("[.]{2,}", ".");

        // 4. 마침표(.) 처음이나 끝에 위치 => 제거
		new_id = new_id.replaceAll("^[.]|[.]$", "");

        // 5. 빈 문자열 => "a" 대입
		if (new_id.isEmpty()) {
			new_id = "a";
		}

        // 6. 16자 이상
		if (new_id.length() > 15) {

            // 6-1. 첫 15개의 문자를 제외 나머지 문자 모두 제거
			new_id = new_id.substring(0, 15);

            // 6-2. 마침표(.) 끝에 위치 => 제거
			new_id = new_id.replaceAll("[.]$", "");
		}

        // 7. 2자 이하 => 마지막 문자를 길이가 3이 될 때까지 끝에 붙임
		while (new_id.length() < 3) {
			new_id += new_id.charAt(new_id.length() - 1);
		}
        
        return new_id;
    }
}
```

<br/>

---

### 교재 풀이

```java

public class Solution {
    public String solution(String newId) {
        newId = newId.toLowerCase();
        newId = newId.replaceAll("[^a-z0-9\\-_.]", "");
        newId = newId.replaceAll("\\.+", ".");
        newId = newId.replaceAll("^\\.+|\\.+$", "");
        if (newId.isEmpty()) newId = "a";
        if (newId.length() >= 16) {
            newId = newId.substring(0, 15);
            newId = newId.replaceAll("\\.+$", "");
        }
        while (newId.length() < 3) {
            newId += newId.charAt(newId.length() - 1);
        }

        return newId;
    }
}

```
