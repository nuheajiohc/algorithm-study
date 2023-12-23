import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine().toUpperCase();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++){
            Character c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }

        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        if(list.size()==1){
            System.out.println(list.get(0).getKey());
            return;
        }

        if (Objects.equals(list.get(0).getValue(), list.get(1).getValue())){
            System.out.println("?");
        }else{
            System.out.println(list.get(0).getKey());
        }
    }
}
