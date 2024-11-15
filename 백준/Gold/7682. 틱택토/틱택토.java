import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] board= new char[3][3];

        StringBuilder sb = new StringBuilder();
        String line;
        while (!(line = br.readLine()).equals("end")) {

            int O = 0;
            int X = 0;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    board[i][j] = line.charAt(i*3+j);
                    if(board[i][j] == 'O'){
                        O++;
                    }else if(board[i][j] == 'X'){
                        X++;
                    }
                }
            }

            if(!(X==O || X==O+1)){
                sb.append("invalid\n");
                continue;
            }

            int OThree=0;
            int XThree=0;
            for(int i = 0; i < 3; i++){
                int temp=0;
                for(int j = 0; j < 3; j++){
                    if(board[i][j] == board[i][0]){
                        temp++;
                    }
                }
                if(temp==3){
                    if(board[i][0]=='O') OThree++;
                    else if(board[i][0]=='X') XThree++;
                }
            }

            for(int i = 0; i < 3; i++){
                int temp=0;
                for(int j = 0; j < 3; j++){
                    if(board[j][i] == board[0][i]){
                        temp++;
                    }
                }
                if(temp==3){
                    if(board[0][i]=='O') OThree++;
                    else if(board[0][i]=='X') XThree++;
                }
            }

            int temp=0;
            for(int i = 0; i < 3; i++){
                if(board[i][i]==board[0][0]) temp++;
            }
            if(temp==3){
                if(board[0][0]=='O') OThree++;
                else if(board[0][0]=='X') XThree++;
            }

            temp =0;
            for(int i = 0; i < 3; i++){
                if(board[i][2-i]==board[0][2]) temp++;
            }
            if(temp==3){
                if(board[0][2]=='O') OThree++;
                else if(board[0][2]=='X') XThree++;
            }

            if(X==O){
                if(XThree==0 && OThree==1){
                    sb.append("valid\n");
                }else{
                    sb.append("invalid\n");
                }
            }else{
                if(OThree==0&&(XThree>0 || (XThree==0 && O+X==9))){
                    sb.append("valid\n");
                }else{
                    sb.append("invalid\n");
                }
            }
        }
        System.out.println(sb);
    }
}
