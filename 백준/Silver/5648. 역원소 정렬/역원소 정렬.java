import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        while(N>0){
            while(st.hasMoreTokens()){
                arr[--N] = reverse(Long.parseLong(st.nextToken()));
            }
            if(N>0){
                st = new StringTokenizer(br.readLine());
            }
        }


        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(long num : arr){
            sb.append(num).append("\n");
        }
        System.out.println(sb.toString());

    }

    public static long reverse(long num){
        long newNum =0;
        int digit=0;
        while(num>0){
            long r = num%10;
            long temp=1;
            for(int i=0; i<digit; i++){
                temp*=10;
            }
            newNum=r*temp+newNum*10;
            num/=10;
        }

        return newNum;
    }
}
