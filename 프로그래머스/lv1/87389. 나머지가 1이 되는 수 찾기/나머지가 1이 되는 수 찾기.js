function solution(n) {
    let answer;
    for(let i=1;i<n;i+=1){
        if(n%i===1){
            answer=i;
            break;
        }
    }
    return answer;
}