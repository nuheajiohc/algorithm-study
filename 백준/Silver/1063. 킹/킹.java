import java.io.*;
import java.util.*;

public class Main {

    private static final int KING=1;
    private static final int STONE=2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king_pos = st.nextToken();
        String stone_pos = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        Point king = new Point(king_pos.charAt(1)-'1',king_pos.charAt(0)-'A');
        Point stone = new Point(stone_pos.charAt(1)-'1', stone_pos.charAt(0)-'A');

        int[][] board = new int[8][8];
        board[king.x][king.y] = KING;
        board[stone.x][stone.y] = STONE;
        while(N-->0){
            String command = br.readLine();
            if(command.equals("R")){
                if(king.y==7) continue;
                if(king.y+1 == stone.y && king.x==stone.x){
                    if(stone.y==7) continue;
                    stone.y+=1;
                    board[stone.x][stone.y]=STONE;
                }
                board[king.x][king.y]=0;
                king.y+=1;
                board[king.x][king.y]=KING;
            }else if(command.equals("L")){
                if(king.y==0) continue;
                if(king.y-1 == stone.y && king.x==stone.x){
                    if(stone.y==0) continue;
                    stone.y-=1;
                    board[stone.x][stone.y]=STONE;
                }
                board[king.x][king.y]=0;
                king.y-=1;
                board[king.x][king.y]=KING;
            }else if(command.equals("B")){
                if(king.x==0) continue;
                if(king.x-1 == stone.x && king.y==stone.y){
                    if(stone.x==0)continue;
                    stone.x-=1;
                    board[stone.x][stone.y]=STONE;
                }
                board[king.x][king.y]=0;
                king.x-=1;
                board[king.x][king.y]=KING;
            }else if(command.equals("T")){
                if(king.x==7) continue;
                if(king.x+1 == stone.x && king.y==stone.y){
                    if(stone.x==7) continue;
                    stone.x+=1;
                    board[stone.x][stone.y]=STONE;
                }
                board[king.x][king.y]=0;
                king.x+=1;
                board[king.x][king.y]=KING;
            }else if(command.equals("RT")){
                if(king.x==7 || king.y ==7) continue;
                if(king.x+1 == stone.x && king.y+1==stone.y){
                    if(stone.x==7 || stone.y==7) continue;
                    stone.x+=1;
                    stone.y+=1;
                    board[stone.x][stone.y]=STONE;
                }
                board[king.x][king.y]=0;
                king.x+=1;
                king.y+=1;
                board[king.x][king.y]=KING;
            }else if(command.equals("LT")){
                if(king.x==7 || king.y==0) continue;
                if(king.x+1 == stone.x && king.y-1==stone.y){
                    if(stone.x==7 || stone.y==0) continue;
                    stone.x+=1;
                    stone.y-=1;
                    board[stone.x][stone.y]=STONE;
                }
                board[king.x][king.y]=0;
                king.x+=1;
                king.y-=1;
                board[king.x][king.y]=KING;
            }else if(command.equals("RB")){
                if(king.x==0 || king.y==7) continue;
                if(king.x-1 == stone.x && king.y+1==stone.y){
                    if(stone.x==0 || stone.y==7) continue;
                    stone.x-=1;
                    stone.y+=1;
                    board[stone.x][stone.y]=STONE;
                }
                board[king.x][king.y]=0;
                king.x-=1;
                king.y+=1;
                board[king.x][king.y]=KING;
            }else{
                if(king.x==0 || king.y==0) continue;
                if(king.x-1 == stone.x && king.y-1 == stone.y){
                    if(stone.x==0 || stone.y==0) continue;
                    stone.x-=1;
                    stone.y-=1;
                    board[stone.x][stone.y]=STONE;
                }
                board[king.x][king.y]=0;
                king.x-=1;
                king.y-=1;
                board[king.x][king.y]=KING;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(board[i][j]==KING){
                    sb.append((char)(j+'A')).append((char)(i+'1')).append("\n");
                }
            }
        }

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(board[i][j]==STONE){
                    sb.append((char)(j+'A')).append((char)(i+'1')).append("\n");               
                }
            }
        }
        System.out.println(sb);
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
