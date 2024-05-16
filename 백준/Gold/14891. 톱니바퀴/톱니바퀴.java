import java.io.*;
import java.util.*;

public class Main {

    private static int[] dir = {-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] gears = new int[5];
        int[] newGears = new int[5];
        for(int i=1; i<5; i++){
            gears[i] = Integer.parseInt(br.readLine(),2);
        }
        int K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int th = Integer.parseInt(st.nextToken());
            int curDir = Integer.parseInt(st.nextToken());
            int idx = curDir==1?1:0;

            boolean[] isRotate = new boolean[5];
            newGears[th] = rotate(gears[th],idx);
            isRotate[th] = true;
            for(int j=th+1; j<=4; j++){
                if(isSame(gears[j-1],gears[j])) break;
                idx= (idx+1)%2;
                newGears[j] = rotate(gears[j],idx);
                isRotate[j]=true;
            }

            idx = curDir==1?1:0;
            for(int j=th-1; j>=1; j--){
                if(isSame(gears[j],gears[j+1])) break;
                idx = (idx+2-1)%2;
                newGears[j] = rotate(gears[j],idx);
                isRotate[j]=true;
            }

            for(int j=1; j<5; j++){
                if(isRotate[j]) gears[j] = newGears[j];
            }
        }

        int result=0;
        for(int i=1; i<=4; i++){
            if(gears[i]>>7==1){
                result+=1<<(i-1);
            }
        }
        System.out.println(result);
    }

    public static int rotate(int gear, int idx){
        if(dir[idx]==1){
            gear = ((gear>>1) | ((gear<<7)& 255));
        }else{
            gear = ((gear<<1)& 255) | (gear>>7);
        }
        return gear;
    }

    public static boolean isSame(int leftGear, int rightGear){
        return (((leftGear<<2)& 255)>>7) == (((rightGear<<6)& 255)>>7);
    }
}
