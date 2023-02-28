function solution(lines) {
    const arr = Array.from({length:201},()=>0);
    lines.forEach(([a,b])=>{
        for(let i=a+100;i<b+100;i+=1){
            arr[i]+=1;
        }
    })
    let answer = arr.reduce((acc,cur)=>{
       if(cur>1) acc+=1;
        return acc;
    },0)
    return answer;
}