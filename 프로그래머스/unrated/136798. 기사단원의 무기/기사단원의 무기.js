function solution(number, limit, power) {
    let answer = 0;
    
    for(let i=1;i<=number;i+=1){
        const set = new Set();
        for(let j=1;j<=Math.sqrt(i);j+=1){
            if(i%j===0){
                set.add(j);
                set.add(i/j);
            }
        }
        set.size > limit? answer+=power: answer+=set.size;
    }
    
    return answer;
}