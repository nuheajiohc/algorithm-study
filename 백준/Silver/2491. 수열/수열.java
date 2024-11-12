import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max=1;

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count=1;
        for(int i=1; i<N; i++){
            if(arr[i-1]<=arr[i]){
                count++;
            }else{
                count=1;
            }
            max = Math.max(max, count);
        }

        count=1;
        for(int i=1; i<N; i++){
            if(arr[i-1]>=arr[i]){
                count++;
            }else{
                count=1;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
