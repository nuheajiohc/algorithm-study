function solution(i, j, k) {
    const arr= Array.from({length:j-i+1},()=>i++);
    const newArr=arr.join("").split("").sort().map(Number);
    const answer=newArr.filter(el=>el===k).length;
    return answer;
}