import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[][] board;
    static int[][] mark;
    static int[] arr = new int[1000001];
    static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            mark = new int[N][N];
            
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    arr[board[i][j]] = i*N+j;
                }
            }
            
            int value = N*N;
            int len = 0;
            for(int i=N*N; i>0; i--) {
                int x = arr[i]/N;
                int y = arr[i]%N;
                boolean possible=false;
                for(int dir=0; dir<4; dir++) {
                    int nx = x+dx[dir];
                    int ny = y+dy[dir];
                    if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                    if(board[x][y]+1 == board[nx][ny]) {
                        mark[x][y] = mark[nx][ny]+1;
                        possible = true;
                        if(len <= mark[x][y]){
                            value = board[x][y];
                            len = mark[x][y];
                        }
                        break;
                    }
                }
                if(!possible) {
                    mark[x][y]=1;
                }
            }

            sb.append("#").append(tc).append(" ").append(value).append(" ").append(len).append("\n");
        }
        System.out.println(sb);
    }
}

