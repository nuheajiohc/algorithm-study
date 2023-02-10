function solution(price) {
    let answer;
    if(price>=500000) answer = price*0.8;
    else if(price>=300000) answer = price*0.9;
    else if(price>=100000) answer = price*0.95;
    else answer=price;
    return Math.floor(answer);
}