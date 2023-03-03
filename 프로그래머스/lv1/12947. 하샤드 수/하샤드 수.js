function solution(x) {
    let sum=0;
    let strX = String(x);
    for(let i of strX){
        sum+=+i;
    }
    const answer = x%sum===0;
    return answer;
}
