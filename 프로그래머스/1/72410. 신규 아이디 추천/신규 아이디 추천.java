class Solution {
    public String solution(String new_id) {
        
        String first = new_id.toLowerCase();
        String second = "";
        for(int i=0; i<first.length(); i++){
            char c = first.charAt(i);
            if((c>='a' && c<='z') || c=='-' || c=='_' || c=='.' || (c>='0' && c<='9')){
                second += String.valueOf(first.charAt(i));
            }
        }
        
        String third = "";
        for(int i=0; i<second.length(); i++){
            char c = second.charAt(i);
            if(i<second.length()-1){
                char next = second.charAt(i+1);
                if(c == '.' && next == '.'){
                    continue;
                }else{
                    third += String.valueOf(second.charAt(i));
                }    
            }else{
               third += String.valueOf(second.charAt(i));
            }
        }
        
        if(third.charAt(0)=='.'){
            third = third.substring(1);
        }
            
        if(third.length()>1 && third.charAt(third.length()-1)=='.'){
            third = third.substring(0, third.length()-1);
        }
        
        String fourth = third;
        
        String fifth = "";
        if(fourth.length()==0){
            fifth = "a";
        }else{
            fifth = fourth;
        }
        
        String sixth=fifth;
        if(sixth.length()>=16){
            sixth = sixth.substring(0,15);
            if(sixth.charAt(14)=='.'){
                sixth = sixth.substring(0,14);
            }
        }
    
        String seventh = sixth;
        while(seventh.length()<=2){
            seventh+=String.valueOf(sixth.charAt(sixth.length()-1));
        }
        
        
        return seventh;
    }
}