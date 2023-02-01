// function solution(s) {
//     var answer = [];
//     const alphabet= new Array(26).fill(0);
//     for(let i=0;i<s.length;i+=1){
//         if(alphabet[s.charCodeAt(i)-97]===0){
//             answer.push(-1);
//         }else{
//             answer.push(i-alphabet[s.charCodeAt(i)-97][1]);
//         }
//         alphabet[s.charCodeAt(i)-97]=[alphabet[s.charCodeAt(i)-97],i];
//     }
//     return answer;
// }

function solution(s) {
    var answer = [];
    const alphabet= new Array(26);
    for(let i=0;i<s.length;i+=1){
        if(alphabet[s.charCodeAt(i)-97]===undefined){
            answer.push(-1);
        }else{
            answer.push(i-alphabet[s.charCodeAt(i)-97]);
        }
        alphabet[s.charCodeAt(i)-97]=i;
    }
    return answer;
}