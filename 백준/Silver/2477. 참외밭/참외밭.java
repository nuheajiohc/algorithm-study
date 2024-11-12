import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());;
        int[][] arr= new int[6][2];
        int idx = 0;
        for(int i=0; i<6; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            if(arr[idx][1]<arr[i][1]){
                idx = i;
            }
        }
        int count = K;
        int a = arr[(idx+1)%6][1];
        int b = arr[(idx+6-1)%6][1];
        if(a<b){
            count *= arr[idx][1]*b-arr[(idx+6-3)%6][1]*arr[(idx+6-4)%6][1];
        }else{
            count *= arr[idx][1]*a-arr[(idx+3)%6][1]*arr[(idx+4)%6][1];
        }
        System.out.println(count);
    }
}
