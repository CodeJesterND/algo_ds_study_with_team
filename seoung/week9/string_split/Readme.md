# 문자열 나누기 
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/140108)


# 문제 풀이 
1. toCharArray를 통해서 char형 배열을 선언 해준다. 
2. f_count, o_count, totalCount를 선언 해주었고 f_count는 첫번째 문자랑 똑같은 문자 개수, o_count 다른 개수, totalCount(마지막 개수를 구해주기 위하여 만들어줌)는 모든 카운트를 말한다. 
3. first == ' ' 을 통해서 첫번째 문자인지 판별하고 첫번째 문자열이라면 fcount를 올려주었다. 
4. targetword.length == totalCount는 마지막 문자가 첫글자인 것에 대한 처리이다. continue를 통해서 위로 올려줌
5. 그 밑에는 ch != first 첫 번째 문자와 다르다면 o_count++ , 첫 번째랑 동일하다면 f_count++ 해준다. 
6. 그 후에 두개의 개수가 똑같으면 answer를 1하나 증가 시켜주고, first= ' ';로 만들어준다.
 
```
/**
1. 먼저 첫 글자를 읽습니다. 이 글자를 x라고 한다.
2. 이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, x와 x가 아닌 다른 글자들이 나온 횟수를 각각 센다. 
3. 처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리합니다. 
4. s에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복한다. 남은 부분이 없다면 종료한다. 
5. 만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고 종료한다. 
*/
class Solution {
    public int solution(String s) {
        int answer = 0;
        char []targetWord = s.toCharArray();
        char first = ' ';
        int f_count =0,o_count=0,totalCount = 0;
        for(char ch : targetWord){
            totalCount++;
            if(first == ' ') {
                first = ch;
                f_count++;
                if(targetWord.length == totalCount) answer++;
                continue;
            }
            
            if(ch != first) {
                o_count++;
            } else if(ch == first) {
                f_count++;
            }
            
            if(f_count==o_count){
                answer++;
                first=' ';
            } else if(totalCount==targetWord.length){
                answer++;
            } 
        }
        
        return answer;
    }
}
```

