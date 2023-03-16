function solution(array, commands) {
    const answer = commands.map(([i,j,k],index)=>{
        return array.slice(i-1,j).sort((a,b)=>a-b)[k-1]
    })
    return answer;
}