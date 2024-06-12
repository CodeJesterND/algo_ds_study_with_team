# 최대공약수와 최소공배수 
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/12940)

최대 공약수는 유클리드 호제법 a % b를 나눈 나머지가 r 일 때, a와 b의 최대공약는 b와 r의 최대 공약수와 같다. 
<br>
최소 공배수 : 두 수의 곱에서 최대 공약수를 나눈것과 최대 공약수는 같다.

````
class Solution {
    /**
    최대 공약수 : 유클리드 호제법 => 2개의 자연수 a,b (a>b)에 대해서 a를 b로 나눈 나머지가 r일 때, a와 b의 최대공약수는 b와 r의 최대 공약수와 같다. 
    최대 공약수 : 두 수의 곱에서 최대 공약수를 나눈것과 최대 공약수는 같다. 
    */
    public int[] solution(int n, int m) {
        
        int a = Math.max(n,m);
        int b = Math.min(n,m);
        
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        
        return new int[]{a,n*m/a};
    }
}
````