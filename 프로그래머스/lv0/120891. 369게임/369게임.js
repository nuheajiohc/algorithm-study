function solution(order) {
    // const answer = order.toString().split("").map(a=>+a).filter(a=>a===3||a===6|a===9).length;
    const answer = order.toString().split(/[3,6,9]/g).length-1;
    return answer;
}