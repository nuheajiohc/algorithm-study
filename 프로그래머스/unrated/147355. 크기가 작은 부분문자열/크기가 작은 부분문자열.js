function solution(t, p) {
    let answer = 0;
    const pNumber = Number(p);
    const pLength = p.length;
    for(let i=0;i<=t.length-pLength;i+=1){
        const tNumber=Number(t.slice(i,i+pLength));
        if(tNumber<=pNumber){
            answer+=1;
        }
    }
    return answer;
}