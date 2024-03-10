import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] minguk = br.readLine().split(" ");
        String[] manse = br.readLine().split(" ");

        int minguk_sum = 0;
        int manse_sum = 0;
        for (int i = 0; i < 4; i++) {
            minguk_sum += Integer.parseInt(minguk[i]);
            manse_sum += Integer.parseInt(manse[i]);
        }
        if(minguk_sum>manse_sum){
            System.out.println(minguk_sum);
        }else{
            System.out.println(manse_sum);
        }
    }
}
