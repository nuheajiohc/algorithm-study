function solution(numbers) {
    const num = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    let answer=numbers; 
    num.forEach((el,i)=>{
        answer = answer.replaceAll(el,i);
    })
    return Number(answer);
}