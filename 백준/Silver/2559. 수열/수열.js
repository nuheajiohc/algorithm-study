const input = require("fs").readFileSync(0).toString().trim().split("\n");
const [N, K] = input.shift().split(" ").map(Number);
const numberList = input[0].split(" ").map(Number);
const sum = [0];
for (let j = 0; j < K; j += 1) {
  sum[0] += numberList[j];
}
for (let i = K; i <= N - 1; i += 1) {
  sum.push(sum.at(-1) + numberList[i] - numberList[i - K]);
}
console.log(Math.max(...sum));
