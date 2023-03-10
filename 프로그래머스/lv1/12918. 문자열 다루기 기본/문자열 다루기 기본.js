function solution(s) {
    let answer;
    if(s.length!==4 && s.length!==6){
        return false;
    }
    const regex=/[a-zA-Z]/g;
    answer = !regex.test(s);
    return answer;
}