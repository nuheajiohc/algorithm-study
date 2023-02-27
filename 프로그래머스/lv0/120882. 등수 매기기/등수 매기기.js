function solution(score) {
    const answer = score.map(([eng,math])=>{
        let count=1;
        for(let i=0; i<score.length; i+=1){
            if(eng+math<score[i][0]+score[i][1]) count+=1;
        }
        return count;
    })
    return answer;
}