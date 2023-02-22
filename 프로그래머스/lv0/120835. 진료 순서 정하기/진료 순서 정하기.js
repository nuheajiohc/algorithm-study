function solution(emergency) {
    const order=[...emergency].sort((a,b)=>b-a).map((el,i)=>[el,i+1]);
    const orderMap= new Map(order);
    const answer = emergency.map(el=>orderMap.get(el));
    return answer;
}