import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] height = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int count=0;
        int temp=0;
        for(int i=0; i<H; i++){
            boolean isStart=false;
            for(int j=0; j<W; j++){
                if(!isStart && height[j]>=i+1){
                    isStart=true;
                }else if(isStart){
                    if(height[j]<i+1){
                        temp++;
                    }else{
                        count+=temp;
                        temp=0;
                    }
                }
            }
            temp=0;
        }
        System.out.println(count);
    }
}
