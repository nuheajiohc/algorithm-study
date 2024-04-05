import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr,op;
    private static int N;
    private static int maxVal = Integer.MIN_VALUE;
    private static int minVal = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0,arr[0]);
        System.out.println(maxVal);
        System.out.println(minVal);
    }

    public static void backtracking(int depth,int value){
        if(depth==N-1){
            maxVal = Math.max(maxVal,value);
            minVal = Math.min(minVal,value);
            return;
        }

        if(op[0]>0){
            op[0]--;
            backtracking(depth+1,value+arr[depth+1]);
            op[0]++;
        }
        if(op[1]>0){
            op[1]--;
            backtracking(depth+1,value-arr[depth+1]);
            op[1]++;  
        }
        if(op[2]>0){
            op[2]--;
            backtracking(depth+1,value*arr[depth+1]);
            op[2]++;  
        }
        if(op[3]>0){
            op[3]--;
            backtracking(depth+1,value/arr[depth+1]);
            op[3]++;  
        }
    }
}
