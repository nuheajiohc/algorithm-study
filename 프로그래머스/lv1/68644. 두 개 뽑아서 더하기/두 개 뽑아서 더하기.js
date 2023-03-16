function solution(numbers) {
    const answerSet = new Set();
    for(let i=0;i<numbers.length-1;i+=1){
        for(let j=i+1;j<numbers.length;j+=1){
            answerSet.add(numbers[i]+numbers[j]);
        }
    }
    const answer = [...answerSet].sort((a,b)=>a-b);
    return answer;
}