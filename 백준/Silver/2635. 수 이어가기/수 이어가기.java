import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count=0;
        int num=0;
        for(int i=1; i<=N; i++){
            int temp = recur(N,i,2);
            if(count<temp){
                count =temp;
                num = i;
            }
        }

        System.out.println(count);
        int[] arr = new int[count];
        arr[0] = N;
        arr[1] = num;
        for(int i=2; i<count; i++){
            arr[i] = arr[i-2]-arr[i-1];
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static int recur(int a, int b, int count){
        if(b>a) return count;
        return recur(b, a-b, count+1);
    }
}
