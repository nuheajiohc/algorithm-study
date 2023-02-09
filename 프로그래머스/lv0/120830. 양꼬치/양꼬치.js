function solution(n, k) {
    const service=Math.floor(n/10)
    var answer = n*12000+(k-service)*2000
    return answer;
}