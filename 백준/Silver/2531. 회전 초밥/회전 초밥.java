import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[N];
        for(int i=0; i<N; i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] sushiCount = new int[d+1];
        int[] result = new int[N];
        int maxCount=0;

        int count=0;
        for(int i=0; i<k; i++){
            sushiCount[sushi[i]]++;
            if(sushiCount[sushi[i]]==1) count++;
        }
        result[0] = count;
        if(sushiCount[c]==0) count++;
        maxCount=count;
        

        for(int start=1; start<N; start++){
            int temp = result[start-1];
            sushiCount[sushi[start-1]]--;
            if(sushiCount[sushi[start-1]]==0) temp--;

            sushiCount[sushi[(start+k-1)%N]]++;
            if(sushiCount[sushi[(start+k-1)%N]]==1)temp++;

            result[start] = temp;
            if(sushiCount[c]==0) temp++;
            maxCount=Math.max(maxCount,temp);
            
        }
        System.out.println(maxCount);
    }
}
