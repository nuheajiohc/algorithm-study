import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr = new int[9];
    private static boolean[] used = new boolean[9];
    private static boolean found = false;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        btk(0,0,0);

    }

    public static void btk(int k, int sum,  int count){
        if(found) return;
        if(sum>100) return;

        if(count==7 && sum==100){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<9; i++){
                if(!used[i]) continue;
                sb.append(arr[i]).append("\n"); 
            }
            System.out.println(sb);
            found=true;
            return;
        }

        for(int i=k; i<9; i++){
            used[i]=true;
            btk(i+1, sum+arr[i], count+1);
            used[i]=false;
        }
    }
}
