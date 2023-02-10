function solution(my_string) {
    const n=new Set("123456789");
    const answer = [...my_string].reduce((acc,cur)=>n.has(cur)?acc+(+cur):acc,0);
    return answer;
}