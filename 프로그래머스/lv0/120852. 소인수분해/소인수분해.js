function solution(n) {
    const answer = new Set();
    let num = n;
    for(let i=2;i<=n;){
        if(num%i===0){
            answer.add(i);
            num/=i;
            continue;
        }
        i+=1;
    }
    return [...answer];
}