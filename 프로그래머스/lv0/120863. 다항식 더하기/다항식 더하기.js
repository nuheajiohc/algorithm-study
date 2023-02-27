function solution(polynomial) {
    let a=0;
    let b=0;
    const arr = polynomial.split(" + ");
    arr.forEach(el=>{
        if(el.includes("x")){
            const p=el.slice(0,-1);
            p?a+=Number(p):a+=1;
        }else{
            b+=Number(el);
        }
    })
    let answer ="";
    if(a>0 &&b>0) answer =`${a!==1?a:""}x + ${b}`;
    else if(a>0 &&b===0) answer = `${a!==1?a:""}x`;
    else if (a===0 && b>0) answer = `${b}`;
    return answer;
}