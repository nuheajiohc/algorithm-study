function solution(n)
{
    let answer = 0;
    const str = String(n);
    for(let i of str)
        answer+=Number(i);
    return answer;
}