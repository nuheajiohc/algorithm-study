function solution(babbling) {
    let answer = 0;
    babbling.forEach(el=>{
        const check =el.replace(/aya|ye|woo|ma/g,"");
        if(check==="") answer+=1;
    })
    return answer;
}