import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        prev[0] = -1;
        for(int i=1; i<n; i++){
            prev[i] = i-1;
        }
        next[n-1] = -1;
        for(int i=0; i<n-1; i++){
            next[i] = i+1;
        }
        
        Deque<Integer> deleted = new ArrayDeque<>();
        
        int cur = k;
        for(int i=0; i<cmd.length; i++){
            StringTokenizer st = new StringTokenizer(cmd[i]);
            String command = st.nextToken();
            if(command.equals("U")){
                int size = Integer.parseInt(st.nextToken());
                while(size-->0){
                    cur = prev[cur];
                }
            }else if(command.equals("D")){
                int size = Integer.parseInt(st.nextToken());
                while(size-->0){
                    cur = next[cur];
                }
            }else if(command.equals("C")){
                deleted.offerLast(cur);
                if(next[cur]!=-1){
                    prev[next[cur]] = prev[cur];
                }
                if(prev[cur]!=-1){
                    next[prev[cur]] = next[cur];
                }
                
                if(next[cur]==-1){
                    cur = prev[cur];
                }else{
                    cur = next[cur];
                }
            }else{
                int idx = deleted.pollLast();
                if(prev[idx]!=-1) next[prev[idx]] = idx;
                if(next[idx]!=-1) prev[next[idx]] = idx;
            }
        }
        
        char[] ans = new char[n];
        Arrays.fill(ans, 'O');
        while(!deleted.isEmpty()) ans[deleted.poll()] = 'X';
        
        return new String(ans);
    }
}