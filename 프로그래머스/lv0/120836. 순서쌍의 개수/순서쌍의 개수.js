function solution(n) {
    let answer = 0;
    for(let i=1;i<=Math.sqrt(n);i+=1){
        if(n%i===0) answer+=2;
        if(i===Math.sqrt(n)) answer-=1;
    }
    return answer;
}