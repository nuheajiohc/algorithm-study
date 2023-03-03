function solution(numbers) {
    const uniqueNum = new Set(numbers);
    
    var answer = [0,1,2,3,4,5,6,7,8,9].reduce((acc,cur)=>{
        if(uniqueNum.has(cur)===false)
            acc+=cur;
        return acc;
    },0)
    return answer;
}