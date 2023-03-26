function solution(answers) {
    const answer = [];
    const one = [1,2,3,4,5];
    const two = [2,1,2,3,2,4,2,5];
    const three = [3,3,1,1,2,2,4,4,5,5];
    let score = [0,0,0];
    answers.forEach((ans,number)=>{
        if(one[number%one.length]===ans) score[0]+=1;
        if(two[number%two.length]===ans) score[1]+=1;
        if(three[number%three.length]===ans) score[2]+=1;
    })
    const MaxScore=Math.max(...score);
    score.forEach((el,i)=>el===MaxScore && answer.push(i+1));
    return answer;
}