# 삼총사 

``````
import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int[] number) {
       
        int []arr = new int[3];
       
    
        dfs(number, 0, arr, 0);
        return answer;
    }
    
     static void dfs(int[] number,int count, int[] arr, int startIndex){
        if(count==3){
            int sum = Arrays.stream(arr).sum();
            if(sum==0) answer++;
            return ;
        }
 
        //count가 증가함 3개일 때 뱉어야함. 그러고 하나 증가 
        for(int i=startIndex;i<number.length; i++){
            arr[count] = number[i];
            dfs(number, count+1, arr, i+1);
        }
        
        
    }
}
``````