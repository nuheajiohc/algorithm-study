class Solution {
    public String solution(String p) {
        String answer = recursion(p);
        return answer;
    }
    
    public String recursion(String p){
        if(p.isEmpty()){
            return "";
        }
        
        int left = 0;
        int right = 0;
        boolean isBalanced = true;
        
        String u = "";
        String v = "";
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            
            if(left<right) isBalanced = false;
            if(left!=right) continue;
            
            u += p.substring(0,i+1);
            v += p.substring(i+1);
            if(isBalanced){
                u += recursion(v);
                break;
            }else{
                String tmp = u.substring(1,u.length()-1);
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<tmp.length(); j++){
                    if(tmp.charAt(j)=='('){
                        sb.append(")");
                    }else{
                        sb.append("(");
                    }
                }
                u = "(" + recursion(v) + ")" + sb.toString();
                break;
            }         
        }
        
        return u;
    }
}