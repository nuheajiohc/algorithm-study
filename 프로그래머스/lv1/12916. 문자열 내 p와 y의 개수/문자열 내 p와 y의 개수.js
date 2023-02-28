function solution(s){
    let pNum=0;
    let yNum=0;
    for(let str of s){
        if(str==="p"||str==="P") pNum+=1;
        if(str==="y"||str==="Y") yNum+=1;
    }
    const answer = pNum===yNum;
    return answer;
}