import java.io.*;

public class Main {

    private static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringBuilder sb= new StringBuilder();
        int[][] board= new int[N+2][N+2];
        for(int i=1; i<=N; i++){
            String line = br.readLine();
            for(int j=1; j<=N; j++){
                if(line.charAt(j-1)=='*'){
                    board[i][j]=1;
                }else{
                    board[i][j]=0;
                }
            }
        }

        Point heart = findHeart(board);
        sb.append(heart.x).append(" ").append(heart.y).append("\n");
        for(int i=1; i<=N+1; i++){
            if(board[heart.x][i]==1){
                sb.append(heart.y-i).append(" ");
                break;
            }
        }
        for(int i=N; i>=heart.y; i--){
            if(board[heart.x][i]==1){
                sb.append(i-heart.y).append(" ");
                break;
            }
        }

        Point leftLeg = null;
        Point rightLeg = null;
        for(int i=heart.x+1; i<=N+1; i++){
            if(board[i][heart.y]==0){
                sb.append(i-heart.x-1).append(" ");
                leftLeg = new Point(i,heart.y-1);
                rightLeg = new Point(i,heart.y+1);
                break;
            }
        }

        for(int i=leftLeg.x; i<=N+1; i++){
            if(board[i][leftLeg.y]==0){
                sb.append(i-leftLeg.x).append(" ");
                break;
            }
        }

        for(int i=rightLeg.x; i<=N+1; i++){
            if(board[i][rightLeg.y]==0){
                sb.append(i-rightLeg.x).append(" ");
                break;
            }
        }
        System.out.println(sb);
    }

    public static Point findHeart(int[][] board){
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(board[i][j]==0) continue; 
                int count=0;
                for(int dir=0; dir<4; dir++){
                    int nx = i+dx[dir];
                    int ny = j+dy[dir];
                    if(board[nx][ny]==1) count++;
                }
                if(count==4){
                    return new Point(i,j);
                }
            }
        }
        return null;
    }

    public static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
