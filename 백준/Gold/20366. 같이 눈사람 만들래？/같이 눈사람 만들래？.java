import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] radius = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            radius[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(radius);

        int minDiff=Integer.MAX_VALUE;
        for(int i=0; i<N-1; i++){
            for(int j=i+3; j<N; j++){
                int snowman1=radius[i]+radius[j];
                int e=j-1;
                int s=i+1;
                while(s<e && s<j && e>i){
                    int snowman2 = radius[s]+radius[e];
                    int diff = Math.abs(snowman1-snowman2);
                    if(minDiff>diff){
                        minDiff = diff;
                    }
                    if(snowman1<snowman2){
                        e--;
                    }else if(snowman1>snowman2){
                        s++;
                    }else{
                        break;
                    }
                }
            }
        }
        System.out.println(minDiff);
    }
}
