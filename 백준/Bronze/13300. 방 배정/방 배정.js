const input = require("fs").readFileSync(0).toString().trim().split("\n");
const [N, K] = input.shift().split(" ").map(Number);
const numberList = input.map(el => el.split(" ").map(Number));
const cnt = new Array(2).fill(0).map(() => new Array(7).fill(0));
for (let i = 0; i < N; i += 1) {
  const [a, b] = numberList[i];
  cnt[a][b] += 1;
}
let result = 0;
for (let i = 0; i <= 1; i += 1) {
  for (let j = 1; j <= 6; j += 1) {
    result += Math.ceil(cnt[i][j] / K);
  }
}
console.log(result);
