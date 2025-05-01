import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        
        List<String> list1 = generateList(str1);
        List<String> list2 = generateList(str2);
        
        
        int intersection = countIntersection(list1, list2);
        int union = countUnion(list1, list2);
        
        if(intersection==0 && union==0){
            return 65536;
        }
        
        int answer = (int)(intersection*65536/(double)union);
        return answer;
    }
    
    private int countUnion(List<String> list1, List<String> list2){
        int count=0;
        boolean[] vis = new boolean[list2.size()];
        for(int i=0; i<list1.size(); i++){
            for(int j=0; j<list2.size(); j++){
                if(vis[j]) continue;
                if(list1.get(i).equals(list2.get(j))){
                    vis[j]=true;
                    break;
                }
            }
        }
        
        count = list1.size();
        for(int i=0; i<list2.size(); i++){
            if(vis[i]) continue;
            count++;
        }
        
        return count;
    }
    
    private int countIntersection(List<String> list1, List<String> list2){
        int count=0;
        boolean[] vis = new boolean[list2.size()];
        for(int i=0; i<list1.size(); i++){
            for(int j=0; j<list2.size(); j++){
                if(vis[j]) continue;
                if(list1.get(i).equals(list2.get(j))){
                    count++;
                    vis[j]=true;
                    break;
                }
            }
        }
        return count;
    }
    
    
    private List<String> generateList(String str){
        List<String> list = new ArrayList<>();
        for(int i=1; i<str.length(); i++){
            if(isAlphabet(str.charAt(i-1)) && isAlphabet(str.charAt(i))){
                list.add(str.substring(i-1,i+1).toLowerCase());
            }
        }
        return list;
    }
    
    private boolean isAlphabet(char c){
        return (c>='a' && c<='z') || (c>='A' && c<='Z');
    }
}