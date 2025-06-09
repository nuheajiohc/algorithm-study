class Solution {
    public int solution(int[][] board, int[][] skills) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] sum = new int[N+1][M+1];
        
        for(int[] skill : skills){
            int type = skill[0];
            int x1 = skill[1];
            int y1 = skill[2];
            int x2 = skill[3];
            int y2 = skill[4];
            int degree = skill[5];
            
            if(type==1){
                sum[x1][y1] -= degree;
                sum[x1][y2+1] += degree;
                sum[x2+1][y1] += degree;
                sum[x2+1][y2+1] -= degree;
            }else{
                sum[x1][y1] += degree;
                sum[x1][y2+1] -= degree;
                sum[x2+1][y1] -= degree;
                sum[x2+1][y2+1] += degree;
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=1; j<M; j++){
                sum[i][j] += sum[i][j-1];    
            }
        }
        
        for(int i=1; i<N; i++){
            for(int j=0; j<M; j++){
                sum[i][j] += sum[i-1][j];
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j]+sum[i][j]>0) answer++;
            }
        }
        
        return answer;
    }
}