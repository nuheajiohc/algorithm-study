function solution(n, arr1, arr2) {
    const answer = arr1.map((el,i)=>{
        const temp = el | arr2[i];
        return temp.toString(2).padStart(n,"0").replace(/1/g,"#").replace(/0/g," ");
    })
    return answer;
}