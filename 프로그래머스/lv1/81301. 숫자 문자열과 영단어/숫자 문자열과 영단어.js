function solution(s) {
    var answer = s;
    const numberList = ['zero','one','two','three','four','five','six','seven','eight','nine'];
    numberList.forEach((el,index)=>{
        answer =answer.replaceAll(el,index);
    })
    
    return Number(answer);
}