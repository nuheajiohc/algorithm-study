function solution(n) {
    let answer =1;
    let i=1;
    while(answer<=n){
        answer*=i
        i+=1;
    }
    return i-2;
}