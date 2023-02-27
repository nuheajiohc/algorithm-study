function solution(num, total) {
    const answer = Array.from({length:num},(_,i)=>Math.floor(total/num)-Math.floor((num-1)/2)+i);
    return answer;
}