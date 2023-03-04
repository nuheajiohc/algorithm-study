function solution(s) {
    const answer = s.split(" ").map(str=>{
        if(str===""){
            return "";
        }
        else if(isNaN(str[0])){
            str = str[0].toUpperCase()+str.toLowerCase().slice(1);
            return str;
        }
        str= str[0]+str.toLowerCase().slice(1);
        return str;
    }).join(" ");
    return answer;
}