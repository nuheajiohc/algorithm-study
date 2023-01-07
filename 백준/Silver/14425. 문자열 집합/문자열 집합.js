const input = require("fs").readFileSync(0).toString().trim().split("\n");
const [N, M] = input[0].split(" ").map(a => +a);
const S = new Set(input.slice(1, N + 1));
const check = input.slice(N + 1);
let cnt = 0;
check.forEach(a => S.has(String(a)) ? cnt++ : 0);
console.log(cnt);