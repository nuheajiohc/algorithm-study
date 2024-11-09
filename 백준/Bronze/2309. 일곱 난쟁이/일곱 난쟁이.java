import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum=0;
        int[] arr = new int[9];
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum+=arr[i];
        }
        Arrays.sort(arr);
        int target = sum-100;

        boolean find = false;
        int idx1=0;
        int idx2=0;
        for(int i=0; i<9; i++){
            int temp=0;
            for(int j=i+1; j<9; j++){
                temp= arr[i]+arr[j];
                if(temp==target) {
                    find = true;
                    idx1=i;
                    idx2=j;
                    break;
                }
            }
            if(find) break;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<9; i++){
            if(i==idx1 || i==idx2) continue;
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);

    }
}
