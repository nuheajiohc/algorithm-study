function solution(my_string) {
    const answer= [...my_string].map(el=>el.toUpperCase()===el?el.toLowerCase():el.toUpperCase()).join("");
    return answer;
}

