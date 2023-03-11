function solution(s, n) {
    let answer = '';
    const lowerCase = "abcdefghijklmnopqrstuvwxyz";
    const upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for(let el of s){
        if(el==" "){
            answer+=" ";
        }else if(el===el.toUpperCase()){
            const index = upperCase.indexOf(el);
            answer+=upperCase[(index+n)%26];
        }else{
            const index = lowerCase.indexOf(el);
            answer+=lowerCase[(index+n)%26];
        }
    }    
    return answer;
}