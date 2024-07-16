# [link](https://school.programmers.co.kr/learn/courses/30/lessons/87377)

## 내가 푼 문제 풀이

1. line별로 a,b,e,c,d,f로 받아옴, 각 타입은 long으로 선언 int를 선언하면 overflow 발생 
2. Point 클래스를 선언하여 x,y를 받음 because 함수에서 변수 두 개를 꺼내와야하는데 방법이 없음 
3. insertsection 함수로 문제에서 준 교점 공식을 사용하였다. 
4. if(x!=0 || y !=0)을 해준 이유는 이렇게 안해주면 점이 겁나 많이 생김.. 자세히 보니 정수에 해당 하는 부분만 교점으로 구함  
5. 각각의 min과 max를 구함 why? 이차원 배열을 x,y좌표처럼 구해주어야 하기 때문에 해당 방법으로 maxX - minX +1 , maxY - minY + 1 이런식으로 풀었다.     
6. 이중 for 문을 돌면서을 넣어주었다. 
7.  int x = (int)(list.get(i).x - minX); int y = (int)(maxY - list.get(i).y ); 해당 부분은 y 좌표가 이차원에서는 반대이기 때문에 maxY에서      list.get(i).y 부분을 빼주었다. 사실 안되서 무식하게 다 하나씩 해봄 ㅋㅋ... 
8. 문자형 map 베얄 부분을 string 배열로 바꿔주어 리턴해주었다. 

```
import java.util.*;

class Solution {
    static long maxX = Long.MIN_VALUE;
    static long maxY = Long.MIN_VALUE;
    static long minX = Long.MAX_VALUE;
    static long minY = Long.MAX_VALUE;
    
    static class Point {
        long x;
        long y;
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public String[] solution(int[][] line) {
        String[] answer = {};
        List<Point> list = new ArrayList<>();
        for(int i=0; i<line.length;i++){
            for(int j=i+1; j<line.length; j++){
                Point p = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if(p!=null){
                    list.add(p);
                    maxX = Math.max(maxX, p.x);
                    maxY = Math.max(maxY, p.y);
                    minX = Math.min(minX, p.x);
                    minY = Math.min(minY, p.y);                
                }
    
            }
        }
        
        int width = (int)maxX - (int)minX + 1;
        int height = (int)maxY - (int)minY + 1;
        
        
        char [][]map = new char[height][width];
        
        for(int i=0; i < height; i++){
            for(int j=0; j < width; j++){
                map[i][j] = '.';
            }
        }
        
        for(int i = 0; i <list.size(); i++) {
            int x = (int)(list.get(i).x - minX);
            int y = (int)(maxY - list.get(i).y );
    		map[y][x] = '*';
    	}
        
        answer = new String[height];
        
        for(int i=0; i< answer.length; i++){
            answer[i] = new String(map[i]);
        }
        
        return answer;
    }
    
    public static Point intersection(long a, long b, long e, long c, long d, long f){
      long under = a*d - b*c;
      long over_x = b*f - e*d;
      long over_y = e*c - a*f;
      double x = (double)over_x / under;
      double y = (double)over_y / under;  
     
      if(x % 1 != 0 || y % 1 != 0) {
          return null;
      }
       
      return new Point((long)x,(long)y);
    }
}
```


## 책에서 사용한 문제 풀이

1. 컨셉 자체는 똑같으나 모든 부분을 함수로 나누어주었다. 정말 좋아보였다. 
2. List에 넣은걸 활용하여 함수로가 각각을 구해주었다. maximum, minimum을 포인트 배열에 담아주었음. 
3. for(char[] row : arr) {
   Arrays.fill(row, '.');
   } 이차원 배열에서는 해당 부분이 안 먹기에 일차원 배열로 하나씩 row fill로 해주었음 배열은 주소 값을 가지고 있기 때문에 이런식으로 사용 가능 
```
import java.util.*;

class Solution {
    
    private static class Point {
        public final long x,y;
        
        private Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);
        
        if(x % 1 != 0 || y % 1 != 0) return null;
        
        return new Point((long) x, (long) y);
        
    }
    
    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Point p : points) {
            if (p.x < x ) x = p.x;
            if (p.y < y ) y = p.y;
        }
        
        return new Point(x,y);
    }
    
    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Point p : points) {
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }
        
        return new Point(x, y);
    }
    
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for(int i=0 ; i < line.length; i++) {
            for(int j=i+1; j<line.length; j++){
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if(intersection != null) points.add(intersection);
            }
        }
        
        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);
        
        int width = (int)(maximum.x - minimum.x + 1);
        int height = (int)(maximum.y - minimum.y + 1);
        
        
        char[][] arr = new char[height][width];
        for(char[] row : arr) {
            Arrays.fill(row, '.');
        }
        
        for(Point p : points) {
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);
            arr[y][x] = '*';
        }
        
        
        String[] result = new String[arr.length];
        
        for(int i=0; i <result.length; i++){
            result[i] = new String(arr[i]);
        }
        return result;
    }
}
```