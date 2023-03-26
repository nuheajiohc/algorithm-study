function solution(k, m, score) {
    let answer = 0;
    const appleNum = score.length;
    const maxNum = appleNum- (appleNum%m);
    const sortedScore = [...score].sort((a,b)=>b-a);
    for(let i=0;i<maxNum;i+=m){
        answer+=(sortedScore[i+m-1]*m);
    }
    return answer;
}