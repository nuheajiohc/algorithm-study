function solution(food) {
    var answer = '';
    food.forEach((el,i)=>{
        if(i===0) return;
        answer+=String(i).repeat(Math.floor(el/2));
    })
    answer = answer+"0"+answer.split("").reverse().join("")
    return answer;
}