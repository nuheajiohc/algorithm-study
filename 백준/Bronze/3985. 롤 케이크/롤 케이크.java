import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[L+1];
        int max=0;
        int expect=0;
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(max<b-a){
                max=b-a;
                expect=i;
            }
            for(int j=a; j<=b; j++){
                if(arr[j]>0) continue;
                arr[j]=i;
            }
        }

        int[] count = new int[N+1];
        for(int i=1; i<=L; i++){
            count[arr[i]]++;
        }

        int idx=1;
        for(int i=1; i<=N; i++){
            if(count[idx]<count[i]){
                idx=i;
            }
        }
        System.out.println(expect);
        System.out.println(idx);
    }
}
