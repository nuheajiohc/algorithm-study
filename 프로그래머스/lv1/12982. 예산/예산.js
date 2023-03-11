function solution(d, budget) {
    let totalBudget = 0;
    let answer=0;
    d.sort((a,b)=>a-b);
    for(let i=0;i<d.length;i+=1){
        const tmp = totalBudget+d[i];
        if(tmp<=budget){
            answer+=1;
            totalBudget=tmp;
        }else break;
    }
    return answer;
}
