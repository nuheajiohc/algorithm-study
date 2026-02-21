class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i=0; i<balls.length; i++){
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            
            boolean[] impossible = new boolean[4];
            if(startX == targetX && startY < targetY){
                impossible[3] = true;
            }else if(startX == targetX && startY > targetY){
                impossible[2] = true;
            }else if(startY == targetY && startX > targetX){
                impossible[0] = true;
            }else if(startY == targetY && startX < targetX){
                impossible[1] = true;
            }
            
            int[] dx = {targetX*-2, (m-targetX)*2, 0, 0};
            int[] dy = {0, 0, targetY*-2, (n-targetY)*2};
            
            int min = Integer.MAX_VALUE;
            for(int dir=0; dir<4; dir++){
                if(impossible[dir]) continue;
 
                int nx = targetX + dx[dir];
                int ny = targetY + dy[dir];
                
                int diff = (startX-nx)*(startX-nx) + (startY-ny)*(startY-ny);
                min = Math.min(min, diff);
            }
            answer[i] = min;
        }

        return answer;
    }
}