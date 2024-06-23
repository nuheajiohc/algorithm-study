import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = br.readLine();

        int R=0;
        int C=0;
        for(int i=1; i*i<=message.length(); i++){
            if(message.length()%i==0){
                R=i;
            }
        }
        C = message.length()/R;
        char[][] board = new char[R][C];
        int idx=0;
        for(int i=0; i<C; i++){
            for(int j=0; j<R; j++){
                board[j][i] = message.charAt(idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                sb.append(board[i][j]);
            }
        }
        System.out.println(sb.toString());
    }
}
