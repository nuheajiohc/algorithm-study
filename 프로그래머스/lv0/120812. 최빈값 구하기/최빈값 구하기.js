function solution(array) {
    const answer=array.reduce((acc,cur)=>{
       acc[cur]=(acc[cur] || 0)+1; 
        return acc;
    },{})
    let freq=0;
    let freqKey=0;
    for(let key in answer){
        if(freq<=answer[key]){
             freq=answer[key];
            freqkey=key;
        }
    }
    let count=0;
    for( let key in answer){
        if(answer[key]===freq)count+=1;
    }
    if(count>1) return -1;
    return Number(freqkey);
}