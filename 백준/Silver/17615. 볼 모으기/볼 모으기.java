import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String ball = br.readLine();
        int red=0;
        int blue=0;
        for(int i=0; i<N; i++){
            if(ball.charAt(i)=='B') blue++;
        }
        red = N-blue;

        int min=Integer.MAX_VALUE;
        int temp=0;
        if(ball.charAt(0)=='B'){
            for(int j=0; j<N; j++){
                if(ball.charAt(j)=='B') temp++;
                else break;
            }
        }
        min = Math.min(min, blue-temp);

        temp=0;
        if(ball.charAt(0)=='R'){
            for(int j=0; j<N; j++){
                if(ball.charAt(j)=='R') temp++;
                else break;
            }
        }
        min = Math.min(min, red-temp);

        temp=0;
        if(ball.charAt(N-1)=='B'){
            for(int j=N-1; j>=0; j--){
                if(ball.charAt(j)=='B') temp++;
                else break;
            }
        }
        min = Math.min(min, blue-temp);

        temp=0;
        if(ball.charAt(N-1)=='R'){
            for(int j=N-1; j>=0; j--){
                if(ball.charAt(j)=='R') temp++;
                else break;
            }
        }
        min = Math.min(min, red-temp);

        System.out.println(min);

    }
}
