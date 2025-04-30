// import java.util.*;

// class Solution {
//     public int[] solution(String s) {
//         int[] count = new int[100001];
        
//         String[] splitted = s.substring(2,s.length()-2).split("\\},\\{");
//         for(String str : splitted){
//             StringTokenizer st = new StringTokenizer(str, ",");
//             while(st.hasMoreTokens()){
//                 count[Integer.valueOf(st.nextToken())]++;
//             }
//         }
        
//         List<int[]> list = new ArrayList<>();
//         for(int i=1; i<100001; i++){
//             if(count[i]>0){
//                 list.add(new int[]{i, count[i]});
//             }
//         }
        
//         list.sort((a,b)->b[1]-a[1]);
        
//         int[] answer = new int[list.size()];
//         for(int i=0; i<list.size(); i++){
//             answer[i] = (list.get(i))[0];
//         }
        
//         return answer;
//     }
// }

import java.util.*;
class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}