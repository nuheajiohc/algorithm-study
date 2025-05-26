import java.util.*;

class Solution {
    
    private String[] ops = {"+", "-", "*"};
    private boolean[] vis = new boolean[3];
    
    public long solution(String expression) {
        List<String> list = new LinkedList<>();
        int st =0;

        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i)=='-' || expression.charAt(i)=='+' || expression.charAt(i)=='*'){
                list.add(expression.substring(st, i));
                list.add(Character.toString(expression.charAt(i)));
                st = i+1;
            }
        }
        list.add(expression.substring(st));
        return recursion(list);
    }
    
    public long recursion(List<String> list){
        if(list.size()==1){
            return Math.abs(Long.parseLong(list.get(0)));
        }
        
        long max=0;
        for(int i=0; i<ops.length; i++){
            if(vis[i]) continue;
            List<String> tmp = new LinkedList<>(list);
            vis[i] = true;
            operate(tmp, ops[i]);
            max = Math.max(max, recursion(tmp));
            vis[i] =false;
        }
        return max;
    }
    
    public void operate(List<String> list, String op){
        ListIterator<String> iter = list.listIterator();
        while(iter.hasNext()){
            String value = iter.next();
            if(value.equals(op)){
                iter.remove();
                iter.previous();
                long a = Long.parseLong(iter.next());
                iter.remove();
                long b = Long.parseLong(iter.next());
                iter.remove();
                
                if(value.equals("*")){
                    iter.add(Long.toString(a*b));
                }else if(value.equals("+")){
                    iter.add(Long.toString(a+b));
                }else{
                    iter.add(Long.toString(a-b));
                }
            }
        }
    }
}