function solution(s){
    let answer = true;
    const stack = [];
    for(let i=0;i<s.length;i+=1){
        const cur = s[i];
        if(cur==="("){
            stack.push(cur);
        }else if(cur===")"){
            const stackPop = stack.pop();
            if(stackPop==="("){
                continue;
            }else{
                return false;
            }
        }
    }
    answer = stack.length===0;
    return answer;
}