import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        boolean[] isOpened = new boolean[101];
        int[] openRoomCount = new int[101];
        for(int i=1;i<=100; i++){
            for(int j=1; j<=i; j++){
                if(i%j==0) isOpened[i]= !isOpened[i];
            }
            openRoomCount[i] = openRoomCount[i-1]+ (isOpened[i]?1:0);
        }

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            sb.append(openRoomCount[N]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
