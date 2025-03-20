import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        
        int[][] board = new int[str1.length+1][str2.length+1];

        for(int i=1; i<=str1.length; i++){
            for(int j=1; j<=str2.length; j++){
                board[i][j] = Math.max(board[i-1][j], board[i][j-1]);
                if(str1[i-1] == str2[j-1]){
                    board[i][j] = Math.max(board[i][j],board[i-1][j-1]+1);
                }
            }
        } 

        StringBuilder sb = new StringBuilder();
        
        int max = board[str1.length][str2.length];
        System.out.println(max);
        if(max==0){
            return;
        }

        int x = str1.length-1;
        int y = str2.length-1;

        while(x>=0 && y>=0){
            if(str1[x]==str2[y]){
                sb.append(str1[x]);
                x--;
                y--;
            } else if(board[x+1][y+1] == board[x][y+1]){
                x--;
            } else{
                y--;
            }
        }
        
        System.out.println(sb.reverse());
    }
}
