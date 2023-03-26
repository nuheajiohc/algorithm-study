function solution(N, stages) {
    const order= Array.from({length:N},(_,i)=>[i+1,0]);
    stages.forEach(el=>{
        if(el>N) return;
        order[el-1][1]+=1;
    })
    let playerNumber = stages.length;
    order.sort((a,b)=>a[0]-b[0]);
    const newOrder = order.map(el=>{
        const failRate =el[1]/playerNumber;
        playerNumber -=el[1];
        return [el[0],failRate]
    })
    newOrder.sort((a,b)=>b[1]-a[1]);
    return newOrder.map(el=>el[0]);
}