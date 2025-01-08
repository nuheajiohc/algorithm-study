import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());

      LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();

      for(int i=0; i<N; i++){
        String str = br.readLine();
        for(int j=0; j<str.length(); j++){
          String sub = str.substring(0,j+1);
          if(!map.containsKey(sub)){
            map.put(sub, new ArrayList<>());
          }
          map.get(sub).add(str);
        }
      }


      int max=0;
      String S=null;
      String T=null;
      for(String key : map.keySet()){
          if(map.get(key).size()==1) continue;
          if(max>=key.length()) continue;
          max=key.length();
          S=map.get(key).get(0);
          T=map.get(key).get(1);
      }

      System.out.println(S+"\n"+T);
  }
}
