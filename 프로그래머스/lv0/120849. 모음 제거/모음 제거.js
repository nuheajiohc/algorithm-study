function solution(my_string) {
    const a= new Set("aeiou");
    const answer = [...my_string].map(el=>a.has(el)?"":el).join("");
    return answer;
}