function solution(n) {
    const answer= [];
    for(let i=3;i<=n;i+=1){
        for(let j=2;j<i;j+=1){
            if(i%j===0){
                answer.push(i);
                break;
            }
        }
    }
    return answer.length;
}