function solution(s) {
    let count=0;
    let answer = '';
    
    for(let letter of s){
        if(letter!==" "){
            if(count%2===0){
                answer+=letter.toUpperCase();
            }else{
                answer+=letter.toLowerCase();
            }
            count+=1;
        }else{
            count=0;
            answer+=" ";
        }
    }
    
    return answer;
}