function solution(my_string, n) {
    let answer='';
    [...my_string].forEach(element=>answer+=element.repeat(n));
    return answer;
}