class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[] map = new int[n];
        
        for(int i=0; i<n; i++){
            map[i] = arr1[i] | arr2[i];
        }
        
        for(int i=0; i<n; i++){
            String s = Integer.toString(map[i], 2);
            System.out.println(s);
            s = s.replace("1","#");
            s = s.replace("0", " ");
            if(s.length()<n){
                s = " ".repeat(n-(s.length()))+s;
            }
            answer[i] = s;
        }
        return answer;
    }
}