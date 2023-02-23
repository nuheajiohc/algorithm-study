function solution(s) {
    const count =[...s].reduce((acc,cur)=>{
       acc[cur]=(acc[cur]||0)+1;
        return acc;
    },{})
    const answer =Object.entries(count).filter(el=>(el[1]===1)).map(el=>el[0]);
    return answer.sort().join("");
}