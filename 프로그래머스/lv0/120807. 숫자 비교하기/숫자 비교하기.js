function solution(num1, num2) {
    const answer = compareNum(num1,num2);
    return answer;
}

function compareNum(num1,num2){
    if(num1!==num2){
        return -1;
    }else{
    return 1;
    }
}


// function solution(num1,num2){
//     const answer = ((num1===num2)-0.5)*2;
//     return answer;
// }