function solution(n, lost, reserve) {
    const states = new Array(n+1).fill(1).fill(-1,0,1);
    lost.forEach(el=>states[el]-=1);
    reserve.forEach(el=>states[el]+=1);
    [...reserve].sort((a,b)=>a-b).forEach(el=>{
        if(states[el]===2){
            if(states[el-1]===0)states[el-1]+=1;
            else if(states[el+1]===0)states[el+1]+=1;
        }
    })
    const answer = states.filter(el=>el>0).length;
    return answer;
}