import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Country[] country = new Country[N];
        Country target = null;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            country[i] = new Country(idx,gold,silver,bronze);
            if(idx==M){
                target=country[i];
            }
        }
        Arrays.sort(country);

        for(int i=0; i<N; i++){
            if(target.gold == country[i].gold && target.silver== country[i].silver&& target.bronze== country[i].bronze){
                System.out.println(i+1);
                break;
            }
        }
    }

    public static class Country implements Comparable<Country> {
        int idx;
        int gold;
        int silver;
        int bronze;

        public Country(int idx, int gold, int silver, int bronze){
            this.idx = idx;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country c){
            if(gold==c.gold){
                if(silver==c.silver){
                    return c.bronze-bronze;
                }
                return c.silver-silver;
            }
            return c.gold-gold;
        }
    }
}
