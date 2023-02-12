function solution(age) {
    const alphabet = ['a', 'b', 'c', 'd', 'e', 'f',
        'g', 'h', 'i', 'j'];
    const answer = age.toString().split("").map(a=>alphabet[a]).join("");
    return answer;
}