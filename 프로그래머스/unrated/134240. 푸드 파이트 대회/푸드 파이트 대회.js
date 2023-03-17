function solution(food) {
    const resultArr = [];
    food.forEach((el,i)=>{
        if(Math.floor(el/2)===0)return;
        resultArr.push(i.toString().repeat(Math.floor(el/2)));
    })
    const answer=resultArr.join("")+"0"+resultArr.reverse().join("");
    return answer;
}