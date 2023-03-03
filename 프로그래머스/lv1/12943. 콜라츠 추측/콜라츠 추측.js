function solution(num) {
    let answer =0;
    answer =regration(num,answer);
    return answer;
}

function regration(num,count){
    if(num===1){
        return count;
    }
    if(count===500){
        return -1;
    }
    if(num%2===0){
        count+=1;
        num/=2;
    }else{
        count+=1;
        num= (num*3)+1;
    }
    return regration(num,count);
}
