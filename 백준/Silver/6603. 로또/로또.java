import java.io.*;
import java.util.*;

public class Main {
    
    private static int[] arr;
    private static int[] answer;
    private static int k;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            answer = new int[6];
            if(k==0){
                break;
            }
            for(int i=0; i<k; i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }

            backtracking(0,0);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void backtracking(int cur,int depth){
        if(depth==6){
            for(int n: answer){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=cur; i<k; i++){
            answer[depth]= arr[i];
            backtracking(i+1,depth+1);
        }
    }
}
