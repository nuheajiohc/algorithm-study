import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        List<Integer> w_list = new ArrayList<>();
        List<Integer> h_list = new ArrayList<>();
        while(N-->0){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int th = Integer.parseInt(st.nextToken());
            if(d==0){
                h_list.add(th);
            }else{
                w_list.add(th);
            }
        }
        h_list.add(0);
        w_list.add(0);
        h_list.add(h);
        w_list.add(w);

        Collections.sort(h_list);
        Collections.sort(w_list);

        int max=0;
        for(int i=1; i<h_list.size(); i++){
            for(int j=1; j<w_list.size(); j++){
                max=Math.max(max,(h_list.get(i)-h_list.get(i-1))*(w_list.get(j)-w_list.get(j-1)));
            }
        }

        System.out.println(max);
    }
}
