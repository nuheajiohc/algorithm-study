import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        int temp=t;
        if(w*2<=temp){
            temp%=w*2;
        }
        if(w-p<temp){
            p = w-(temp-(w-p));
        }else{
            p += temp;
        }
        if(p<0){
            p*=-1;
        }

        temp=t;
        if(h*2<=temp){
            temp%=h*2;
        }
        if(h-q<temp){
            q = h-(temp-(h-q));
        }else{
            q += temp;
        }
        if(q<0){
            q*=-1;
        }

        System.out.println(p+" "+q);

    }
}
