import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int temp=0;
        int max=0;
        int maxCount=1;
        for(int i=-0; i<X; i++){
            max += arr[i];
        }
        temp = max;

        for(int i=X; i<N; i++){
            temp+=arr[i];
            temp-=arr[i-X];
            if(max<temp){
                max=temp;
                maxCount=1;
            }else if(max==temp){
                maxCount++;
            }
        }

        if(max==0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(maxCount);
        }
    }
}
