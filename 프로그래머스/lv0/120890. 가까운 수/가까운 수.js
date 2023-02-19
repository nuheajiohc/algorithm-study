function solution(array, n) {
    array.push(n);
    array.sort((a,b)=>a-b);
    const index=array.indexOf(n);
    let answer;
    if(index===0) answer = array[index+1];
    else if(index===array.length-1) answer= array[index-1];
    else {
        if(array[index+1]-array[index]===array[index]-array[index-1]) answer = array[index-1];
        else{
            if(array[index+1]-array[index]>array[index]-array[index-1]){
                answer=array[index-1];
            }else{
                answer=array[index+1];
            }
        }
    }
    
    return answer;
}
    