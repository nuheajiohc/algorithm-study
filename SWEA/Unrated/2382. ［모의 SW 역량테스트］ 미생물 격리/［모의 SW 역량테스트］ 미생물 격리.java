import java.io.*;
import java.util.*;

public class Solution {

    static int N, M, K;
    static int[][] board, maxBoard;
    static int[] dx = {0, -1, 1, 0, 0}, dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            board = new int[N][N];
            maxBoard = new int[N][N];
            List<Micro> micros = new LinkedList<>();
            while(K-->0){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                
                micros.add(new Micro(r, c, n, dir));
                board[r][c] = n;
                maxBoard[r][c] = n;
            }

            while(M-->0){
                Iterator<Micro> iter = micros.iterator();
                while(iter.hasNext()){
                    Micro micro = iter.next();
                    board[micro.x][micro.y] = 0;
                    maxBoard[micro.x][micro.y] = 0;
                    micro.x += dx[micro.dir];
                    micro.y += dy[micro.dir];
                }

                iter = micros.iterator();
                while(iter.hasNext()){
                    Micro micro = iter.next();
                    if(micro.x==0 || micro.x==N-1 || micro.y==0 || micro.y==N-1){
                        micro.n/=2;
                        if(micro.n==0){
                            iter.remove();
                            continue;
                        }else{
                            if(micro.dir == 1 || micro.dir == 3) micro.dir++;
                            else micro.dir--;
                        }
                    }
                    
                    if(maxBoard[micro.x][micro.y] < micro.n){
                        maxBoard[micro.x][micro.y] = micro.n;
                    }
                    board[micro.x][micro.y] += micro.n;
                }

                iter = micros.iterator();
                while(iter.hasNext()){
                    Micro micro = iter.next();
                    if(maxBoard[micro.x][micro.y] > micro.n) iter.remove();
                    else micro.n = board[micro.x][micro.y];
                }
            }

            int sum = 0;
            for(Micro micro : micros){
                sum += micro.n;
            }
            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }

        System.out.println(sb);
    }

    static class Micro{
        int x, y, n, dir;

        Micro(int x, int y, int n ,int dir){
            this.x = x;
            this.y = y;
            this.n = n;
            this.dir = dir;
        }
    }
}
