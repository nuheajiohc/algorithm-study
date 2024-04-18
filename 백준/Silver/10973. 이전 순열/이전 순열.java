import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] dic = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            dic[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N-1; i>0; i--){
            if(dic[i]<dic[i-1]){
                int temp=dic[i];
                int idx=i;
                for(int j=i; j<N; j++){
                    if(dic[i-1]>dic[j] && temp<dic[j]){
                        temp=dic[j];
                        idx=j;
                    }
                }
                int tmp = dic[idx];
                dic[idx] = dic[i-1];
                dic[i-1] = tmp;
                Arrays.sort(dic,i,N,(a,b)->b-a);
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<N; j++){
                    sb.append(dic[j]).append(" ");
                }
                System.out.println(sb.toString());
                return;
            }
        }
        System.out.println(-1);
    }
}
