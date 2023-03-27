function solution(dartResult) {
    const score = [];
    let num="";
    for(let i of dartResult){
        if(Number(i)%1===0){
            num+=i;
        }else if(i==="S"){
            score.push(Number(num));
            num="";
        }else if(i==="D"){
            score.push(Number(num));
            score[score.length-1]=score.at(-1)**2;
            num="";
        }else if(i==="T"){
            score.push(Number(num));
            score[score.length-1]=score.at(-1)**3;
            num="";
        }else if(i==="*"){
            score[score.length-1]=score.at(-1)*2;
            if(score.length>1){
                score[score.length-2]=score.at(-2)*2;
            }
        }else if(i==="#"){
            score[score.length-1]=score.at(-1)*(-1);
        }
    }
    const answer = score.reduce((acc,cur)=>{
            return acc+cur;
        },0)
    return answer;
}