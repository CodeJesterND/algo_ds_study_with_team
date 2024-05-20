package programmers.week06.secretmap;


class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map1 = binaryChangeMap(n, arr1);
        String[] map2 = binaryChangeMap(n, arr2);
        String[] answer = mergeIsNewMap(map1, map2);

        return answer;
    }

    public String[] binaryChangeMap(int n, int[] arr) {
        String[] map = new String[n];
        int[] nubers;
        for (int i = 0; i < n; i++) {
            String binary = Integer.toBinaryString(arr[i]);
            while (binary.length() < n) {
                binary = '0' + binary;
            }
            map[i] = binary;
        }
        return map;
    }

    public String[] mergeIsNewMap(String[] map1, String[] map2) {
        int n = map1.length;
        String[] mergedMap = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (map1[i].charAt(j) == '1' || map2[i].charAt(j) == '1') {
                    sb.append("#");
                } else {
                    sb.append(' ');
                }
            }
            mergedMap[i] = sb.toString();
        }
        return mergedMap;
    }
}

public class SecretMap {
    public static void main(String[] args) {
        Solution so = new Solution();

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] result = so.solution(n, arr1, arr2);
        for (String line : result) {
            System.out.println(line);
        }
    }
}