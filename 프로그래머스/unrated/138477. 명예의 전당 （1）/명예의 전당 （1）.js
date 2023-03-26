function solution(k, score) {
    const answer = [];
    let order = [];
    score.forEach(el=>{
        order.push(el);
        order = order.sort((a,b)=>b-a).slice(0,k);
        answer.push(order.at(-1));
    })
    return answer;
}