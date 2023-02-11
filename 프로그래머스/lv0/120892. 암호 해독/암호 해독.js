function solution(cipher, code) {
    const answer = [...cipher].reduce((acc,cur,i)=>(i+1)%code===0?acc+cur:acc,"");
    return answer;
}