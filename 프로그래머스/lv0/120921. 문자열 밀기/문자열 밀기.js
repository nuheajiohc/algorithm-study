// function solution(A, B) {
//     const newStrA = A+A;
//     const newStrB = B+B;
//     const answer=Math.min(newStrA.indexOf(B),newStrB.indexOf(A))
//     return answer;
// }


function solution(A, B) {
    var answer = 0;
    const BB= B.repeat(2);
    // answer =BB.includes(A)?BB.indexOf(A):-1;
    answer = BB.indexOf(A);
    return answer;
}